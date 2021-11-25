package hw2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF overall;
    private WeightedQuickUnionUF overallV;
    private boolean[] orav;
    private int len;
    private double p = 0.5;
    private int numOpen = 0;
    private int top, bottom;
    private int startBottomIndex;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N should be greater than 0.");
        }
        top = N * N;
        bottom = top + 1;
        overallV = new WeightedQuickUnionUF(top + 2);
        overall = new WeightedQuickUnionUF(top + 1);
        orav = new boolean[N * N];
        len = N;
        startBottomIndex = (len - 1) * len;
    }               // create N-by-N grid, with all sites initially blocked

    public void open(int row, int col) {
        if (row >= len || col >= len || row < 0 || col < 0) {
            throw new IndexOutOfBoundsException("Out of index range!");
        }
        int index = xyTo1D(row, col);
        if (orav[index]) {
            return;
        }
        orav[index] = true;
        numOpen += 1;
        if (row == 0) {
            overall.union(col, top);
            overallV.union(col, top);
        }
        if (row == len - 1) {
            overallV.union(startBottomIndex + col, bottom);
        }
        checkUnion(row, col, index);
    }      // open the site (row, col) if it is not open already

    /**
     * Check if there is need to union the new open item. If there is, union.
     * @param row
     * @param col
     * @param id: xyTo1D(row, col)
     */
    private void checkUnion(int row, int col, int id) {
        int[][] neighbor = new int[4][2];
        neighbor[0] = new int[]{row, col - 1};
        neighbor[1] = new int[]{row, col + 1};
        neighbor[2] = new int[]{row - 1, col};
        neighbor[3] = new int[]{row + 1, col};
        for (int i = 0; i < 4; i++) {
            try {
                int indexN = xyTo1D(neighbor[i][0], neighbor[i][1]);
                if (orav[indexN]) {
                    overall.union(id, indexN);
                    overallV.union(id, indexN);
                }
            } catch (IndexOutOfBoundsException e) {
                continue;
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (row >= len || col >= len || row < 0 || col < 0) {
            throw new IndexOutOfBoundsException("Out of index range!");
        }
        int index = xyTo1D(row, col);
        return orav[index];
    } // is the site (row, col) open?

    /**
     * Only check open item.
     * @param row
     * @param col
     * @return true if it is full.
     */
    public boolean isFull(int row, int col) {
        if (row >= len || col >= len || row < 0 || col < 0) {
            throw new IndexOutOfBoundsException("Out of index range!");
        }
        int id = xyTo1D(row, col);
        return overall.connected(id, top);
    } // is the site (row, col) full?

    public int numberOfOpenSites() {
        return numOpen;
    }          // number of open sites

    public boolean percolates() {
        if (overallV.connected(top, bottom)) {
            return true;
        }
        return false;
    }

    private int xyTo1D(int r, int c) {
        if (r >= len || c >= len || r < 0 || c < 0) {
            throw new IndexOutOfBoundsException("Out of index range!");
        }
        return r * len + c;
    }

    public static void main(String[] args) {
        String filename = "./inputFiles/input3.txt";
        In in = new In(filename);
        int N = 3;
        Percolation perc = new Percolation(N);
        /**
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        } */
        perc.open(2, 2);
        perc.open(1, 2);
        perc.open(0, 2);
        perc.open(2, 0);

        boolean a = perc.isFull(2, 0);
    }
}

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    public String msg = null;
    private void compareDeques(StudentArrayDeque stu, ArrayDequeSolution slo) {
        int x = (int) stu.removeFirst(), y = (int) slo.removeFirst();
        assertEquals(msg, y, x);
    }

    private void addItemR(StudentArrayDeque stu, ArrayDequeSolution slo, int n) {
        for (int i = 0; i < n; i += 1) {
            double num = StdRandom.uniform();

            if (num < 0.5) {
                stu.addLast(i);
                slo.addLast(i);
                msg = msg + "addLast(" + i + ")\n";
            } else {
                stu.addFirst(i);
                slo.addFirst(i);
                msg = msg + "addFirst(" + i + ")\n";
            }
        }
    }

    private void removeItemR(StudentArrayDeque stu, ArrayDequeSolution slo, int n) {
        for (int i = 0; i < n; i += 1) {
            double num = StdRandom.uniform();

            if (num < 0.5) {
                stu.removeLast();
                slo.removeLast();
                msg = msg + "removeLast()\n";
            } else {
                stu.removeFirst();
                slo.removeFirst();
                msg = msg + "removeFirst()\n";
            }
        }
    }

    private void addItem(StudentArrayDeque stu, ArrayDequeSolution slo, int n, boolean l) {
        if (l) {
            for (int i = 0; i < n; i += 1) {
                stu.addLast(i);
                slo.addLast(i);
                msg = msg + "addLast(" + i + ")\n";
            }
        } else {
            for (int i = 0; i < n; i += 1) {
                stu.addFirst(i);
                slo.addFirst(i);
                msg = msg + "addFirst(" + i + ")\n";
            }
        }
    }

    private void removeItem(StudentArrayDeque stu, ArrayDequeSolution slo, int n, boolean l) {
        if (l) {
            for (int i = 0; i < n; i += 1) {
                msg = msg + "removeLast()\n";
                int x = (int) stu.removeLast(), y = (int) slo.removeLast();
                assertEquals(msg, y, x);
            }
        } else {
            for (int i = 0; i < n; i += 1) {
                msg = msg + "removeFirst()\n";
                int x = (int) stu.removeFirst(), y = (int) slo.removeFirst();
                assertEquals(msg, y, x);
            }
        }

    }


    @Test
    public void testMthd() {
        msg = null;
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> hp = new ArrayDequeSolution<>();

        addItemR(sad1, hp, 100);
        removeItem(sad1, hp, 100, false);
    }
}
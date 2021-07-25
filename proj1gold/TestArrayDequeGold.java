import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    private void compareDeques(StudentArrayDeque stu, ArrayDequeSolution slo, String mthd) {
        for (int i = 0; i < slo.size(); i++) {
            int x = (int) stu.removeFirst(), y = (int) slo.removeFirst();

            String msg = "There are problems in " + mthd + ", student was " + x +", correct was " + y;
            assertEquals(msg, y, x);
        }
    }

    private void addItem(StudentArrayDeque stu, ArrayDequeSolution slo, int n) {
        for (int i = 0; i < n; i += 1) {
            double num = StdRandom.uniform();

            if (num < 0.5) {
                stu.addLast(i);
                slo.addLast(i);
            } else {
                stu.addFirst(i);
                slo.addFirst(i);
            }
        }
    }

    private void removeItem(StudentArrayDeque stu, ArrayDequeSolution slo, int n) {
        for (int i = 0; i < n; i += 1) {
            double num = StdRandom.uniform();

            if (num < -0.5) {
                stu.removeFirst();
                slo.removeFirst();
            } else {
                stu.removeLast();
                slo.removeLast();
            }
        }
    }

    @Test
    public void addT() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> hp = new ArrayDequeSolution<>();

        addItem(sad1, hp, 100);
        removeItem(sad1, hp, 99);


        for (int i = 0; i < 20; i++) {
            sad1.addFirst(i);
            hp.addFirst(i);
        }

        String mthd = "addFirst";
        compareDeques(sad1, hp, mthd);

    }

    @Test
    public void addLT() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> hp = new ArrayDequeSolution<>();

        addItem(sad1, hp, 100);
        removeItem(sad1, hp, 100);

        for (int i = 0; i < 20; i++) {
            sad1.addLast(i);
            hp.addLast(i);
        }
        String mthd1 = "addLast";
        compareDeques(sad1, hp, mthd1);
    }

    @Test
    public void rmvT() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> hp = new ArrayDequeSolution<>();

        //addItem(sad1, hp, 100);
        //removeItem(sad1, hp, 100);

        addItem(sad1, hp, 100);
        for (int i = 0; i < 90; i++) {
            sad1.removeFirst();
            hp.removeFirst();
        }
        String mthd1 = "removeFirst";
        compareDeques(sad1, hp, mthd1);
    }

    @Test
    public void rmvLT() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> hp = new ArrayDequeSolution<>();

        //addItem(sad1, hp, 100);
        //removeItem(sad1, hp, 100);

        addItem(sad1, hp, 100);
        for (int i = 0; i < 90; i++) {
            sad1.removeLast();
            hp.removeLast();
        }
        String mthd1 = "removeLast";
        compareDeques(sad1, hp, mthd1);
    }

}

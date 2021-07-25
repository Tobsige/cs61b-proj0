import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    private void compareDeques(StudentArrayDeque stu, ArrayDequeSolution slo) {
        for (int i = 0; i < slo.size(); i++) {
            int x = (int) stu.removeFirst(), y = (int) slo.removeFirst();

            String msg = "There are problems in addFirst(), student was " + x +", correct was " + y;
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
    public void autoG(){
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> hp = new ArrayDequeSolution<>();

        for (int i = 0; i < 20; i++) {
            sad1.addFirst(i);
            hp.addFirst(i);
        }

        compareDeques(sad1, hp);
    }
}

/**
 * An array deque test file.
 *
 * @author Xueyi Wang
 */
public class ArrayDequeTest {

    public static void addRemoveTest() {
        ArrayDeque<Integer> a = new ArrayDeque<>();

        a.addFirst(0);
        a.removeLast();
        a.addFirst(2);
        a.removeFirst();
        a.addFirst(4);
        a.addLast(5);
        a.get(0);
        a.removeFirst();
        a.addLast(8);
        int b = a.removeFirst();

    }

    public static void main(String[] args) {
        addRemoveTest();
    }
}

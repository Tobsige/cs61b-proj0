/**
 * An array deque test file.
 *
 * @author Xueyi Wang
 */
public class ArrayDequeTest {

    public static void addRemoveTest() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(0);
        a.addFirst(1);
        a.get(0);
        a.addLast(3);
        a.addFirst(4);
        a.addFirst(5);
        a.addFirst(6);
        a.addLast(7);
        a.addLast(8);
        a.removeFirst();
        a.addLast(10);
        a.removeFirst();
        a.addFirst(12);
        a.addFirst(13);
        a.addLast(14);
        a.addFirst(15);
        a.addFirst(16);
        a.addFirst(17);
        a.addFirst(18);
        a.addLast(19);
        a.removeFirst();
        a.addLast(21);
        a.addFirst(22);
        a.addFirst(23);
    }

    public static void main(String[] args) {
        addRemoveTest();
    }
}

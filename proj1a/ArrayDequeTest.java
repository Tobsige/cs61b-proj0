/**
 * An array deque test file.
 *
 * @author Xueyi Wang
 */
public class ArrayDequeTest {

    public static void addRemoveTest() {
        ArrayDeque<Integer> a = new ArrayDeque<>();

        a.addLast(0);
        a.get(0);
        a.addLast(2);
        a.removeFirst();
        a.addLast(4);
        a.addFirst(5);
        a.addLast(6);
        a.get(2);
        a.addFirst(8);
        a.addLast(9);
        a.addLast(10);
        a.removeLast();
        a.addLast(12);
        a.addFirst(13);
        a.get(5);
        a.removeFirst();
        System.out.println(a.get(2));
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        int b = a.get(0);
        a.removeFirst();
        boolean c = a.isEmpty();




        boolean e = a.isEmpty();

    }

    public static void main(String[] args) {
        addRemoveTest();
    }
}

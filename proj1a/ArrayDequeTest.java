public class ArrayDequeTest {

    public static void addRemoveTest() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(1);
        a.addLast(2);
        a.addFirst(3);
        a.addLast(4);
        a.removeFirst();
        a.removeLast();
        System.out.println(a.get(0));
        a.printDeque();
    }

    public static void main(String[] args) {
        addRemoveTest();

    }
}

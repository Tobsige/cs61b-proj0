/**
 * A deque interface.
 *
 * @author Xueyi Wang
 */
public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    boolean isEmpty();
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);

    /**Reverse the order of items*/
    default void reverse() {
        int length = size();
        int count = length - 1;
        while (count != 0) {
            T op = removeFirst();
            addLast(op);
            count--;
        }
    }

    default boolean isEqual(Deque<T> d) {
        int len1 = size();
        int len2 = d.size();
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            if (get(i) != d.get(i)) {
                return false;
            }
        }
        return true;
    }

}

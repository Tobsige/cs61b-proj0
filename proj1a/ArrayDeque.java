/**
 * An array deque.
 *
 * @author Xueyi Wang
 */
public class ArrayDeque<T> {
    private int length;
    private T[] items;
    private int max = 16;
    private T def;     //default
    private double ratio = 0.25;

    public ArrayDeque() {
        items = (T []) new Object[max];
        length = 0;
        def = items[0];
    }

    private void resize() {
        T[] a = (T []) new Object[max * 2];
        System.arraycopy(items, 0, a, 0, length);
        items = a;
        max = max * 2;
    }

    public void addFirst(T item) {
        if (length + 1 > max) {
            resize();
        }
        T[] a = (T []) new Object[max];
        a[0] = item;
        System.arraycopy(items, 0, a, 1, length);
        items = a;
        length += 1;
    }

    public void addLast(T item) {
        if (length + 1 > max) {
            resize();
        }
        items[length] = item;
        length += 1;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }

    public void printDeque() {
        if (this.isEmpty()) {
            return;
        } else {
            for (int i = 0; i < length; i++) {
                System.out.print(items[i]);
                System.out.print(' ');
            }
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return def;
        } else {
            T b = items[0];
            length -= 1;
            if (((double) length / max) < ratio && max > 16) {
                max = max / 2;
            }

            T[] a = (T []) new Object[max];
            System.arraycopy(items, 1, a, 0, length);
            items = a;

            return b;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return def;
        } else {
            length -= 1;
            T result = items[length];
            if (((double) length / max) < ratio && max > 16) {
                max = max / 2;
                T[] a = (T []) new Object[max];
                System.arraycopy(items, 0, a, 0, length);
                items = a;
            } else {
                items[length] = null;
            }
            return result;
        }
    }

    public T get(int index) {
        if (isEmpty() || index >= length || index < 0) {
            return def;
        } else {
            return items[index];
        }
    }

}

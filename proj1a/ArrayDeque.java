/**
 * An array deque.
 *
 * @author Xueyi Wang
 */
public class ArrayDeque<T> {
    private int length;
    private T[] items;
    private double ratio = 0.25;

    private int max = 16;
    private int zeroP = 0;
    private int lastP = 0;

    public ArrayDeque() {
        items = (T []) new Object[max];
        length = 0;
    }
    //enlarge or shrink before max change
    //need right pointers
    //change max, zeroP, lastP in function
    private void resize(boolean b) {
        max = b ? max * 2 : max / 2;
        T[] a = (T []) new Object[max];

        //right number = max - zeroP, left = lastP + 1
        if (zeroP <= lastP) {
            System.arraycopy(items, zeroP, a, 0, length);
        } else {
            System.arraycopy(items, zeroP, a, 0, max - zeroP);
            System.arraycopy(items, 0, a, max - zeroP, lastP + 1);
        }

        zeroP = 0;
        lastP = length - 1;
        items = a;
    }

    //clockwise --> add, counterclockwise --> minus.
    private int minusOne(int p) {
        return (p == 0 ? max - 1 : p - 1);
    }

    private int addOne(int p) {
        return (p == max - 1 ? 0 : p + 1);
    }

    public void addFirst(T item) {
        if (length + 1 > max) {
            resize(true);
        }
        if (items[zeroP] != null) {
            zeroP = minusOne(zeroP);
        }
        items[zeroP] = item;
        length += 1;
    }

    public void addLast(T item) {
        if (length + 1 > max) {
            resize(true);
        }
        if (items[lastP] != null) {
            lastP = addOne(lastP);
        }
        items[lastP] = item;
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
        } else if (zeroP < lastP) {
            for (int i = 0; i < length; i++) {
                System.out.print(items[i]);
                System.out.print(' ');
            }
        } else {
            for (int i = zeroP; i < max; i++) {
                System.out.print(items[i]);
                System.out.print(' ');
            }
            for (int i = 0; i <= lastP; i++) {
                System.out.print(items[i]);
                System.out.print(' ');
            }
        }
    }
    //Invariants: change length.
    //null --> change pointers --> resize.
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            T b = items[zeroP];
            items[zeroP] = null;
            length -= 1;
            if (length != 0) {
                zeroP = addOne(zeroP);
            }

            if (((double) length / max) < ratio && max > 16) {
                resize(false);
            }

            return b;
        }
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            length -= 1;
            T result = items[lastP];
            items[lastP] = null;
            if (length != 0) {
                lastP = minusOne(lastP);
            }

            if (((double) length / max) < ratio && max > 16) {
                resize(false);
            }

            return result;
        }
    }

    private int getIndex(int i) {
        if (zeroP <= lastP || i < max - zeroP) {
            return i + zeroP;
        } else {
            return i - (max - zeroP);
        }
    }

    public T get(int index) {
        if (isEmpty() || index >= length || index < 0) {
            return null;
        } else {
            return items[getIndex(index)];
        }
    }

}

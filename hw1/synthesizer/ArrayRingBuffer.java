package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    private int first;
    private int last;
    private T[] rb;
    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        rb = (T[]) new Object[capacity];
        super.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {

        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        } else if (!isEmpty()) {
            last = plusOne(last);
            rb[last] = x;
            fillCount += 1;
        } else {
            rb[last] = x;
            fillCount += 1;
        }
    }
    public int plusOne(int a) {
        int b = (a < (capacity - 1) ? (a + 1) : 0);
        return b;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T item = rb[first];
        rb[first] = null;
        first = plusOne(first);
        fillCount -= 1;
        return item;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new KeyIterator();
    }
    private class KeyIterator implements Iterator<T> {
        private int poz;
        KeyIterator() {
            poz = first;
        }
        @Override
        public boolean hasNext() {
            if (isEmpty()) {
                return false;
            }
            int pozNext = plusOne(poz);
            if (pozNext == last) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            T item = rb[poz];
            poz = plusOne(poz);
            return item;
        }
    }
}

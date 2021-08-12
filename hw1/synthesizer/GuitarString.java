package synthesizer;

import java.util.Random;

public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = 1.0; //.996; // energy decay factor
    private static final long SEED = 10000;
    private static final Random RANDOM = new Random(SEED);

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        int capacity = (int) (SR / frequency);
        buffer = new ArrayRingBuffer<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        for (int i = 0; i < buffer.capacity(); i++) {
            double r = Math.random() - 0.5;
            buffer.dequeue();
            buffer.enqueue(r);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
        double r1 = buffer.dequeue(), rDrum;
        double r2 = buffer.peek();
        int rr = RANDOM.nextInt(2);
        switch (rr) {
            case 0: rDrum = -1; break;
            case 1: rDrum = 1; break;
            default: rDrum = 1;
        }
        double r = 0.5 * (r1 + r2) * DECAY * rDrum;
        buffer.enqueue(r);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}

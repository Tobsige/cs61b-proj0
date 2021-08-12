import java.util.Random;

public class test {
    private static final long SEED = 10000;
    private static final Random RANDOM = new Random(SEED);

    public static void main(String[] args) {
        int rDrum;
        for (int i = 0; i < 10; i++) {
            int rr = RANDOM.nextInt(2);
            switch (rr) {
                case 0: rDrum = -1; break;
                case 1: rDrum = 1; break;
                default: rDrum = 1;
            }
            System.out.println(rDrum);
        }
    }
}

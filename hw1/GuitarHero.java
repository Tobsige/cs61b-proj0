/** Music */
public class GuitarHero {
    private static final double CONCERT_A = 440.0;
    private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    public static void main(String[] args) {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        /* create two guitar strings, for concert A and C */
        synthesizer.GuitarString stringA = new synthesizer.GuitarString(CONCERT_A);
        synthesizer.GuitarString stringW = new synthesizer.GuitarString(CONCERT_C);
        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index != -1) {
                    double concert = CONCERT_A * Math.pow(2, ((double) index - 24.0) / 12.0);
                    stringW = new synthesizer.GuitarString(concert);

                    stringW.pluck();

                } else if (key == 'a') {
                    stringA.pluck();
                }
            }
            /* compute the superposition of samples */
            double sample = stringW.sample() + stringA.sample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            stringW.tic();
            stringA.tic();
        }
    }
}

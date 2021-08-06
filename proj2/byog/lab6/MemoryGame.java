package byog.lab6;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class MemoryGame {
    private int width;
    private int height;
    private int round = 1;
    private Random rand;
    private boolean gameOver;
    private boolean playerTurn;
    private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final String[] ENCOURAGEMENT = {"You can do this!", "I believe in you!",
                                                   "You got this!", "You're a star!", "Go Bears!",
                                                   "Too easy for you!", "Wow, so impressive!"};

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter a seed");
            return;
        }

        int seed = Integer.parseInt(args[0]);

        MemoryGame game = new MemoryGame(60, 40);
        game.rand = new Random(seed);

        //game.startGame();
        game.startGame();
    }

    public MemoryGame(int width, int height) {
        /* Sets up StdDraw so that it has a width by height grid of 16 by 16 squares as its canvas
         * Also sets up the scale so the top left is (0,0) and the bottom right is (width, height)
         */
        this.width = width;
        this.height = height;
        StdDraw.setCanvasSize(this.width * 16, this.height * 16);
        Font font = new Font("Arial", Font.BOLD, 30);//Monaco
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.white);
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();

        //TODO: Initialize random number generator
    }

    public String generateRandomString(int n) {
        //TODO: Generate random string of letters of length n
        String a = "";
        for (int i = 0; i < n; i++) {
            int num = rand.nextInt(25);
            a += CHARACTERS[num];
        }
        return a;
    }

    public void drawFrame(String s) {
        //TODO: Take the string and display it in the center of the screen
        //TODO: If game is not over, display relevant game information at the top of the screen
        StdDraw.clear(Color.black);
        StdDraw.textLeft(1,38,"Round " + round);
        StdDraw.text(30,38,s);
        StdDraw.textRight(59,38, ENCOURAGEMENT[0]);
        StdDraw.line(0,36, 60, 36);
        //StdDraw.show();
    }

    public void flashSequence(String letters) {
        //TODO: Display each character in letters, making sure to blank the screen between letters
        //StdDraw.clear(Color.BLACK);
        char[] stringMemory = letters.toCharArray();
        for(char c : stringMemory) {
            String s = Character.toString(c);
            StdDraw.text(30,20, s);
            StdDraw.show();
            StdDraw.pause(1000);
            StdDraw.clear(Color.BLACK);
            drawFrame("Watch!");
            StdDraw.show();
            StdDraw.pause(500);
        }
        //StdDraw.setPenColor();
    }

    public String solicitNCharsInput(int n) {
        //TODO: Read n letters of player input
        String s = "";
        for(int i = 0; i < n; i++) {
            while (!StdDraw.hasNextKeyTyped()) {
            }
            char c = StdDraw.nextKeyTyped();
            s += c;
        }
        return s;
    }

    public void startGame() {
        //TODO: Set any relevant variables before the game starts
        int len = 3;
        String fail = "Game Over! You made it to round: ";
        String scss = "Good job!";
        boolean go = true;
        //TODO: Establish Game loop
        while(go) {
            drawFrame("Watch!");
            String stringMemory = generateRandomString(len);
            flashSequence(stringMemory);
            drawFrame("Type!");
            StdDraw.show();
            String stringPlayer = solicitNCharsInput(len);
            go = stringPlayer.equals(stringMemory);

            if(!go) {
                StdDraw.text(30,20,fail + round);
                StdDraw.show();
            } else {
                StdDraw.text(30,20,scss);
                StdDraw.show();
                StdDraw.pause(1500);
                round += 1;
                len += 1;
            }

        }

    }

}

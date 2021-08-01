package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60; //* 16 pixels
    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    private static void addHexagon(int n, TETile[][] a, int xP, int yP) {
        if (n <= 1) {
            return;
        }
        /**
        int xOriginal = xP - n / 2, yOriginal = yP - n, xNum = n, yFinal = 30;
        for (int y = yOriginal; y <= yFinal; y += 1) {
            for (int x = xOriginal, i = 0; i < xNum; x += 1, i += 1) {
                a[x][y] = Tileset.TREE;
                a[x][60 - y + 1] = Tileset.TREE;
            }
            xNum += 2;
            xOriginal -= 1;
        }
         */
        int xOriginal = xP, yOriginal = yP, xNum = n, yFinal = yP + n - 1;
        TETile c = pctr();
        for (int y = yOriginal, j = 0; y <= yFinal; y += 1, j += 1) {

            for (int x = xOriginal, i = 0; i < xNum; x += 1, i += 1) {
                a[x][y] = c;
                a[x][yFinal + n - j] = c;
            }
            xNum += 2;
            xOriginal -= 1;
        }

    }

    private static TETile pctr() {
        int tileNum = RANDOM.nextInt(3);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.WATER;
            default: return Tileset.MOUNTAIN;
        }
    }

    private static void addM(int x, int y, int n, int len, TETile[][] w) {
        for(int i = 0; i < n; i += 1) {
            addHexagon(len, w, x, y);
            y += 2 * len;
        }
    }

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        // fills in a block 14 tiles wide by 4 tiles tall
        //addHexagon(3, world, 30, 30);
        int[] yl = new int[]{3, 4, 5, 4, 3};
        for (int i = 0, x = 5, y = 24, n = 3; i < 5; i++) {
            if (i < 3) {
                y -= n;
                x += 5;
            } else {
                y += n;
                x += 5;
            }
            addM(x, y, yl[i], 3, world);

        }

        // draws the world to the screen
        ter.renderFrame(world);

    }
}

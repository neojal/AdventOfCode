package year2015.day01;

import helpers.InputFileReader;

import java.io.IOException;
import java.io.InputStream;

public class Day01 {

    public static final int EOF = -1;
    public static final char UP = '(';
    public static final int GROUND = 0;

    public static int whatFloor(String filePath) throws IOException {
        InputFileReader inputFileReader = new InputFileReader(filePath);
        InputStream is = inputFileReader.getInputStream();

        int c;
        int floor = GROUND;
        while (isEof(c = is.read())) {
            floor += isUp((char) c) ? 1 : -1;
        }
        return floor;
    }

    private static boolean isUp(char c) {
        return c == UP;
    }

    private static boolean isEof(int c) {
        return c != EOF;
    }
}

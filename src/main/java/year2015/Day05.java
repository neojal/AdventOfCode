package year2015;

import helpers.AoCUseful;

import java.io.BufferedReader;

import static helpers.AoCUseful.consecutiveEqualChars;
import static helpers.AoCUseful.containsAnySubStrings;

public class Day05 {

    private static final String[] FORBIDDEN_STRINGS = {"ab", "cd", "pq", "xy"};

    private final BufferedReader bufferedReader;


    public Day05(BufferedReader bufferedReader) {
        if (bufferedReader == null) {
            throw new IllegalArgumentException("Parameter BufferedReader bufferedReader is null");
        }
        this.bufferedReader = bufferedReader;
    }

    public long getNumberOfNiceStringsPart1() {
        return bufferedReader.lines().parallel().
                filter(s -> AoCUseful.countVowels(s) >= 3).
                filter(s -> consecutiveEqualChars(s, 2).size() > 0).
                filter(s -> !containsAnySubStrings(s, FORBIDDEN_STRINGS)).count();
    }
}

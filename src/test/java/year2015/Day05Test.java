package year2015;

import helpers.AoCInput;
import helpers.AoCUseful;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Test {

    private static final String INPUT_FILE_PATH = "input2015/day05.txt";
    private static BufferedReader bufferedReader;
    private static Day05 day05;

    @BeforeAll
    static void init() throws IOException, URISyntaxException {
        bufferedReader = AoCInput.getBufferedReader(INPUT_FILE_PATH);
        day05 = new Day05(bufferedReader);
    }

    @Test
    void getNumberOfNiceStringsPart1() {
        assertEquals(day05.getNumberOfNiceStringsPart1(), 258);
    }

    @Test
    void getNumberOfNiceStringsPart2() {
        assertEquals(day05.getNumberOfNiceStringsPart2(), 0);
    }

    @Test
    void consecutiveEqualCharsMap() {
        assertEquals(day05.
                getConsecutiveEqualCharRepetitions("aabccdefffg", 2).toString(), "{a=1, c=1, f=2}");
        assertEquals(day05.
                getConsecutiveEqualCharRepetitions("aabccdefffg", 3).toString(), "{f=1}");
    }

    @Test
    void getRepeatedSubstrings()
    {
        assertEquals(day05.getRepeatedSubstrings("qjhvhtzxzqqjkmpbqj",2).toString(), "{qj=2}");
        assertEquals(day05.getRepeatedSubstrings("uurcxstgmygtbstg", 3).toString(), "{stg=1}");
        assertEquals(day05.getRepeatedSubstrings("uurcxaaaygtbstuuu", 2).toString(), "{uu=1}");
        assertEquals(day05.getRepeatedSubstrings("aaabcdeaa", 2).toString(), "{aa=2}");
    }

    @Test
    void containsCharSandwich() {
        assertEquals(day05.containsCharSandwich("qjhvhtzxzqqjkmpb"), true);
    }
}

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

    private static final String INPUT_FILE_PATH = "year2015/inputDay05.txt";
    private static BufferedReader bufferedReader;
    private static Day05 day05;

    @BeforeAll
    static void init() throws IOException, URISyntaxException {
        bufferedReader = AoCInput.getBufferedReader(INPUT_FILE_PATH);
        day05 = new Day05(bufferedReader);
    }

    @Test
    void part1() {
        assertEquals(day05.getNumberOfNiceStringsPart1(), 258);
    }

    @Test
    void consecutiveEqualCharsMap() {
        assertEquals(AoCUseful.
                consecutiveEqualChars("aabccdefffg", 2).toString(), "{a=1, c=1, f=2}");
        assertEquals(AoCUseful.
                consecutiveEqualChars("aabccdefffg", 3).toString(), "{f=1}");
    }

}

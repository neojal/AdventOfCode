package year2015;

import helpers.AoCInput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {

    private static final String inputFilePath = "year2015/inputDay02.txt";
    private static BufferedReader bufferedReader;
    private static Day02 day02;

    @BeforeAll
    static void setup() throws IOException, URISyntaxException {
        AoCInput aoCInput = new AoCInput(inputFilePath);
        bufferedReader = aoCInput.getBufferedReader();
        day02 = new Day02(bufferedReader);
    }

    @Test
    void getTotalAreaOfWrappingPaper() throws IOException {
        assertEquals(day02.getTotalAreaOfWrappingPaper(), 1586300);
    }

    //todo: part2
}

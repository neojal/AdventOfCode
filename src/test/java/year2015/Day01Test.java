package year2015;

import helpers.AoCInput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {

    private static final String inputFilePath = "year2015/inputDay01.txt";
    private static InputStream inputStream;
    private static Day01 day01;

    @BeforeAll
    static void setup() throws FileNotFoundException, URISyntaxException {
        AoCInput aoCInput = new AoCInput(inputFilePath);
        inputStream = aoCInput.getInputStream();
        day01 = new Day01(inputStream);
    }

    @Test
    void visitBasement() throws IOException {
        day01.santaMovingInTheBuilding();
        assertEquals(day01.toString(), "Day01{firstBasementVisit = 1795, finalFloor = 74}");
    }
}

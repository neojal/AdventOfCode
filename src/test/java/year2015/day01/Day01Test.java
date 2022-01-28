package year2015.day01;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class Day01Test {

    private static final String inputFilePath = "year2015/inputDay01-1.txt";

    @Test
    void visitBasement() throws IOException {
        Day01 day01 = new Day01(inputFilePath);
        day01.santaMovingInTheBuilding();
        assertEquals(day01.toString(), "Day01{firstBasementVisit = 1795, finalFloor = 74}");
    }
}

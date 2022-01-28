package year2015.day01;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {

    private static final String filePath = "year2015/inputDay01-1.txt";

    @Test
    void whatFloor() throws IOException {
        assertEquals(Day01.whatFloor(filePath),74 );
    }
}
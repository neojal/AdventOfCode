package year2015;

import helpers.AoCInput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {

    private static final String INPUT_FILE_PATH = "year2015/inputDay03.txt";
    private static InputStream inputStream;
    private static Day03 day03;

    @BeforeAll
    static void setup() throws IOException, URISyntaxException {
        inputStream = AoCInput.getInputStream(INPUT_FILE_PATH);
    }

    @Test
    void getHousesReceivingSantaAndRobot() throws IOException {
        day03 = new Day03(inputStream);
        day03.getHousesReceivingSantaAndRobot();
        assertEquals(day03.toString(), "Day03{santaAloneHousesNumber=2572, santaAndRobotHousesNumber=2631}");
    }
}

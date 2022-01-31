package year2015;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {

    @Test
    void getHousesReceivingSantaAndRobot() throws IOException, URISyntaxException {
        Day03 day03 = new Day03();
        day03.performSantaAndRobotVisits();
        assertEquals(day03.toString(), "Day03{santaAloneHousesNumber=2572, santaAndRobotHousesNumber=2631}");
    }
}

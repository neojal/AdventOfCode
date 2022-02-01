package year2015;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {

    private static Day03 day03;

    @BeforeAll
    static void performHouseVisits() throws IOException, URISyntaxException {
        day03 = new Day03();
        day03.performSantaAndRobotVisits();

    }

    @Test
    void getHousesReceivingSantaAndRobot() {
        assertEquals(day03.toString(), "Day03{santaAloneHousesNumber=2572, santaAndRobotHousesNumber=2631}");
    }
}

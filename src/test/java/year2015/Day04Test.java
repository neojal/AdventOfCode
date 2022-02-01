package year2015;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {

    private static final String SECRET_KEY = "yzbqklnj";
    private static final String FIVE_ZEROES_CONDITION = "00000";
    private static final String SIX_ZEROES_CONDITION = "000000";

    @Test
    void part1() throws NoSuchAlgorithmException {
        Day04 day04 = new Day04();
        assertEquals(day04.getNumberWithCondition(SECRET_KEY, FIVE_ZEROES_CONDITION), 282749);
    }

    @Test
    void part2() throws NoSuchAlgorithmException {
        Day04 day04 = new Day04();
        assertEquals(day04.getNumberWithCondition(SECRET_KEY, SIX_ZEROES_CONDITION), 9962624);
    }
}

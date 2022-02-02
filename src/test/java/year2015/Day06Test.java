package year2015;

import helpers.AoCInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Test {

    private static final String INPUT_FILE_PATH = "input2015/day06.txt";
    private static BufferedReader day06BufferedReader;

    @BeforeEach
    void init() throws IOException, URISyntaxException {
        day06BufferedReader = AoCInput.getBufferedReader(INPUT_FILE_PATH);
    }

    @Test
    void part1() throws IOException {
        Day06ToggleLights day06ToggleLights = new Day06ToggleLights(day06BufferedReader);
        assertEquals(day06ToggleLights.getTotalGridBrightness(), 543903);
    }

    @Test
    void part2() throws IOException {
        Day06LightsLightBrightness day06BrightnessLights = new Day06LightsLightBrightness(day06BufferedReader);
        assertEquals(day06BrightnessLights.getTotalGridBrightness(), 14687245);
    }
}

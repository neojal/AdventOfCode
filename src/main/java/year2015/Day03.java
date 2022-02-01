package year2015;

import helpers.AoCInput;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.LinkedHashSet;
import java.util.Set;

public class Day03 {
    private static final String INPUT_FILE_PATH = "year2015/inputDay03.txt";
    public static final String SPLIT_REGEX = ",";
    private final InputStream INPUT_STREAM;

    private static final int START_X = 0;
    private static final int START_Y = 0;

    private final char UP = '^';
    private final char DOWN = 'v';
    private final char LEFT = '<';
    private final char RIGHT = '>';

    private Set<String> santaAloneHouses;
    private Set<String> santaRobotHouses;

    public Day03() throws FileNotFoundException, URISyntaxException {
        INPUT_STREAM = AoCInput.getInputStream(INPUT_FILE_PATH);
    }

    public void performSantaAndRobotVisits() throws IOException {
        santaAloneHouses = new LinkedHashSet<>();
        Point santaAlonePoint = new Point(START_X, START_Y);
        santaAloneHouses.add(toString(santaAlonePoint));

        santaRobotHouses = new LinkedHashSet<>();
        Point santaPoint = new Point(START_X, START_Y);
        Point robotPoint = new Point(START_X, START_Y);
        santaRobotHouses.add(toString(santaPoint));
        santaRobotHouses.add(toString(robotPoint));

        int c;
        int counter = 0;
        while (AoCInput.isNotEof(c = INPUT_STREAM.read())) {

            santaAloneHouses.add(getNextHouse(c, santaAlonePoint));

            counter++;
            if (isSantaVisiting(counter)) {
                santaRobotHouses.add(getNextHouse(c, santaPoint));
            } else {
                santaRobotHouses.add(getNextHouse(c, robotPoint));
            }
        }
    }

    private boolean isSantaVisiting(int counter) {
        return counter%2 != 0;
    }

    private String getNextHouse(int c, Point point) {
        switch (c) {
            case UP:
                point.y++;
                break;
            case DOWN:
                point.y--;
                break;
            case LEFT:
                point.x--;
                break;
            case RIGHT:
                point.x++;
                break;
        }
        return toString(point);
    }

    public Set<String> getSantaAloneHouses() {
        return santaAloneHouses;
    }

    public Set<String> getSantaRobotHouses() {
        return santaRobotHouses;
    }

    private String toString(Point point) {
        return String.format("%d%s%d", point.x, SPLIT_REGEX, point.y);
    }

    @Override
    public String toString() {
        return "Day03{" +
                "santaAloneHousesNumber=" + getSantaAloneHouses().size() +
                ", santaAndRobotHousesNumber=" + getSantaRobotHouses().size() +
                '}';
    }
}

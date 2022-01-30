package year2015;

import helpers.AoCInput;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Day03 {
    private final InputStream INPUT_STREAM;

    private static final int START_X = 0;
    private static final int START_Y = 0;

    private final char UP = '^';
    private final char DOWN = 'v';
    private final char LEFT = '<';
    private final char RIGHT = '>';

    private int santaAloneHousesNumber;
    private int santaAndRobotHousesNumber;

    public Day03(InputStream inputStream) {
        INPUT_STREAM = inputStream;
    }

    public void getHousesReceivingSantaAndRobot() throws IOException {
        Set<String> santaAloneHouses = new HashSet<>();
        Point santaAlonePoint = new Point(START_X, START_Y);
        santaAloneHouses.add(santaAlonePoint.toString());

        Set<String> santaRobotHouses = new HashSet<>();
        Point santaPoint = new Point(START_X, START_Y);
        Point robotPoint = new Point(START_X, START_Y);
        santaRobotHouses.add(santaPoint.toString());
        santaRobotHouses.add(robotPoint.toString());

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
        santaAloneHousesNumber = santaAloneHouses.size();
        santaAndRobotHousesNumber = santaRobotHouses.size();
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
        return point.toString();
    }

    @Override
    public String toString() {
        return "Day03{" +
                "santaAloneHousesNumber=" + santaAloneHousesNumber +
                ", santaAndRobotHousesNumber=" + santaAndRobotHousesNumber +
                '}';
    }
}

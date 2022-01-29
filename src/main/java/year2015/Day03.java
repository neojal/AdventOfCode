package year2015;

import helpers.AoCInput;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Day03 {

    private static final int START_X = 0;
    private static final int START_Y = 0;
    private final InputStream INPUT_STREAM;

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
        Position santaAlonePosition = new Position(START_X, START_Y);
        santaAloneHouses.add(santaAlonePosition.toString());

        Set<String> santaRobotHouses = new HashSet<>();
        Position santaPosition = new Position(START_X, START_Y);
        Position robotPosition = new Position(START_X, START_Y);
        santaRobotHouses.add(santaPosition.toString());
        santaRobotHouses.add(robotPosition.toString());

        int c;
        int counter = 0;
        while (AoCInput.isNotEof(c = INPUT_STREAM.read())) {

            santaAloneHouses.add(getNextHouse(c, santaAlonePosition));

            counter++;
            if (isSantaVisiting(counter)) {
                santaRobotHouses.add(getNextHouse(c, santaPosition));
            } else {
                santaRobotHouses.add(getNextHouse(c, robotPosition));
            }
        }
        santaAloneHousesNumber = santaAloneHouses.size();
        santaAndRobotHousesNumber = santaRobotHouses.size();
    }

    private boolean isSantaVisiting(int counter) {
        return counter%2 != 0;
    }

    private String getNextHouse(int c, Position position) {
        int posX = position.getPosX();
        int posY = position.getPosY();

        switch (c) {
            case UP:
                position.setPosY(posY+1);
                break;
            case DOWN:
                position.setPosY(posY-1);
                break;
            case LEFT:
                position.setPosX(posX-1);
                break;
            case RIGHT:
                position.setPosX(posX+1);
                break;
        }
        return position.toString();
    }

    @Override
    public String toString() {
        return "Day03{" +
                "santaAloneHousesNumber=" + santaAloneHousesNumber +
                ", santaAndRobotHousesNumber=" + santaAndRobotHousesNumber +
                '}';
    }

    private class Position {
        private int posX;
        private int posY;

        Position(int posX, int posY) {
            this.posX = posX;
            this.posY = posY;
        }

        int getPosX() {
            return posX;
        }

        void setPosX(int posX) {
            this.posX = posX;
        }

        int getPosY() {
            return posY;
        }

        void setPosY(int posY) {
            this.posY = posY;
        }

        @Override
        public String toString() {
            return String.format("%d-%d", posX, posY);
        }
    }
}

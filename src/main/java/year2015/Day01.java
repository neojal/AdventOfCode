package year2015;

import helpers.AoCInput;

import java.io.IOException;
import java.io.InputStream;

public class Day01 {

    private static final char GO_UP = '(';
    private static final int FIRST_BASEMENT = -1;
    private static final int GO_UP_ONE_FLOOR = 1;
    private static final int GO_DOWN_ONE_FLOOR = -1;
    private static final int BASEMENT_NOT_VISITED = 0;

    private final InputStream INPUT_STREAM;
    private int currentFloor;
    private int firstBasementVisit;

    public Day01(InputStream inputStream) {
        INPUT_STREAM = inputStream;
        currentFloor = 0;
        firstBasementVisit = 0;
    }

    public void santaMovingInTheBuilding() throws IOException {
        int currentStep;
        int stepsNumber = 0;

        while (AoCInput.isNotEof( currentStep = INPUT_STREAM.read())) {
            currentFloor += getStepDirection(currentStep);
            stepsNumber ++;
            if (isBasementNotVisited()) {
                firstBasementVisit = stepsNumber;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Day01{firstBasementVisit = %d, finalFloor = %d}",
                firstBasementVisit, currentFloor);
    }

    private int getStepDirection(int currentStep) {
        return isUp(currentStep) ? GO_UP_ONE_FLOOR : GO_DOWN_ONE_FLOOR;
    }

    private boolean isFirstBasement() {
        return currentFloor == FIRST_BASEMENT;
    }

    private boolean isBasementVisited() {
        return firstBasementVisit == BASEMENT_NOT_VISITED;
    }

    private boolean isBasementNotVisited() {
        return isFirstBasement() && isBasementVisited();
    }

    private boolean isUp(int currentStep) {
        return (char) currentStep == GO_UP;
    }
}

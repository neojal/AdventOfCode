package year2015.day01;

import helpers.AoCInput;

import java.io.IOException;
import java.io.InputStream;

public class Day01 {

    private static final char GO_UP = '(';
    private static final int FIRST_BASEMENT = -1;
    private static final int GO_UP_ONE_FLOOR = 1;
    private static final int GO_DOWN_ONE_FLOOR = -1;
    private static final int BASEMENT_NOT_VISITED = 0;

    private final InputStream inputStream;

    private int currentFloor;
    private int firstBasementVisit;

    public Day01(String inputFilePath) {
        inputStream = AoCInput.getInputStream(inputFilePath);
        setCurrentFloor(0);
        setFirstBasementVisit(0);
    }

    public void santaMovingInTheBuilding() throws IOException {
        int currentStep;
        int stepsNumber = 0;

        while (AoCInput.isNotEof( currentStep = inputStream.read())) {
            setCurrentFloor( getCurrentFloor() + getStepDirection(currentStep) );

            stepsNumber ++;
            if (isBasementNotVisited()) {
                setFirstBasementVisit(stepsNumber);
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Day01{firstBasementVisit = %d, finalFloor = %d}",
                getFirstBasementVisit(), getCurrentFloor());
    }

    private int getStepDirection(int currentStep) {
        return isUp(currentStep) ? GO_UP_ONE_FLOOR : GO_DOWN_ONE_FLOOR;
    }

    private boolean isFirstBasement() {
        return getCurrentFloor() == FIRST_BASEMENT;
    }

    private boolean isBasementVisited() {
        return getFirstBasementVisit() == BASEMENT_NOT_VISITED;
    }

    private boolean isBasementNotVisited() {
        return isFirstBasement() && isBasementVisited();
    }

    private boolean isUp(int currentStep) {
        return (char) currentStep == GO_UP;
    }

    private int getCurrentFloor() {
        return currentFloor;
    }

    private void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    private int getFirstBasementVisit() {
        return firstBasementVisit;
    }

    private void setFirstBasementVisit(int firstBasementVisit) {
        this.firstBasementVisit = firstBasementVisit;
    }
}

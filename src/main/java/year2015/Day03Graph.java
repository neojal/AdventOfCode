package year2015;

import helpers.AoCPointsPainter;
import helpers.AoCPainterTools;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

public class Day03Graph {
    private static final String SPLIT_REGEX = ",";

    public static void main(String[] args) throws IOException, URISyntaxException {

        Day03 day03 = new Day03();
        day03.performSantaAndRobotVisits();

        Set<String> santaAloneHouses = day03.getSantaAloneHouses();
        ArrayList<Point> santaAlonePoints = AoCPainterTools.pointsListFromStrings(santaAloneHouses, SPLIT_REGEX);

        AoCPointsPainter.Builder santaAloneBuilder = getSantaAloneBuilder(santaAlonePoints);
        SwingUtilities.invokeLater(santaAloneBuilder::build);

        Set<String> santaRobotHouses = day03.getSantaRobotHouses();
        ArrayList<Point> santaRobotPoints = AoCPainterTools.pointsListFromStrings(santaRobotHouses, SPLIT_REGEX);

        AoCPointsPainter.Builder santaRobotBuilder = getSantaRobotBuilder(santaRobotPoints);
        SwingUtilities.invokeLater(santaRobotBuilder::build);

    }

    private static AoCPointsPainter.Builder getSantaRobotBuilder(ArrayList<Point> santaRobotPoints) {
        AoCPointsPainter.Builder builderSantaRobot = new AoCPointsPainter.
                Builder(santaRobotPoints).
                scale(7).
                title("2015-D03-p02 - Santa and Robot visited houses");
        return builderSantaRobot;
    }

    private static AoCPointsPainter.Builder getSantaAloneBuilder(ArrayList<Point> santaAlonePoints) {
        AoCPointsPainter.Builder builder = new AoCPointsPainter.
                Builder(santaAlonePoints).
                scale(7).
                title("2015-D03-p01 - Santa's visited houses").
                sleepTime(10).
                pointColor(Color.GREEN);
        return builder;
    }
}

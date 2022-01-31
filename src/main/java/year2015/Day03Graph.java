package year2015;

import helpers.AoCPointsPainter;
import helpers.AoCPaintTools;

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
        ArrayList<Point> santaAlonePoints = AoCPaintTools.pointsListFromStrings(santaAloneHouses, SPLIT_REGEX);

        AoCPointsPainter.Builder builder = new AoCPointsPainter.
                Builder(santaAlonePoints).
                scale(7).
                title("2015-D03-p01 - Santa's visited houses").
                sleepTime(10).
                pointColor(Color.GREEN);
        SwingUtilities.invokeLater(builder::build);

        Set<String> santaRobotHouses = day03.getSantaRobotHouses();
        ArrayList<Point> santaRobotPoints = AoCPaintTools.pointsListFromStrings(santaRobotHouses, SPLIT_REGEX);

        AoCPointsPainter.Builder builderSantaRobot = new AoCPointsPainter.
                Builder(santaRobotPoints).
                scale(7).
                title("2015-D03-p02 - Santa and Robot visited houses");
        SwingUtilities.invokeLater(builderSantaRobot::build);

    }
}

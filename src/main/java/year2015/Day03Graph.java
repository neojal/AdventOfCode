package year2015;

import helpers.AoCGraph;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;

public class Day03Graph extends JFrame {
    private JPanel jPanel;
    private static final boolean JFRAME_RESIZABLE = true;
    private static final String JFRAME_TITLE = "Day03Graph - AoC-2015";
    private static final Dimension DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();

    private static int rectangleX = 20;
    private static int rectangleY = 60 ;
    private static int rectangleBorder = 1;

    private static int rectangleWidth;
    private static int rectangleHeight;

    private static int xOffset;
    private static int yOffset;

    private static int factor;

    private static ArrayList<Point> santaAlonePoints;
    private static final String SPLIT_REGEX = ",";
    private int counter = 0;

    private Day03Graph() {
        initJPanel();
        initJFrame();
    }

    private void initJPanel() {

        jPanel = new JPanel();
        add(jPanel);
        setPreferredSize(DIMENSION);
    }

    private void initJFrame() {

        setTitle(JFRAME_TITLE);
        setSize(DIMENSION);
        setResizable(JFRAME_RESIZABLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException, URISyntaxException {

        Day03 day03 = new Day03();
        day03.performSantaAndRobotVisits();
        Set<String> santaAloneHouses = day03.getSantaAloneHouses();

        santaAlonePoints = AoCGraph.pointsListFromStrings(santaAloneHouses, SPLIT_REGEX);

        setupDrawArea();

        SwingUtilities.invokeLater(Day03Graph::new);

    }

    private static void setupDrawArea() {
        Point minSantaAlonePoint = AoCGraph.getMinEdgePoint(santaAlonePoints);
        Point maxSantaAlonePoint = AoCGraph.getMaxEdgePoint(santaAlonePoints);

        factor = 7;

        rectangleBorder = 1;
        rectangleX = 20;
        rectangleY = 60;
        rectangleWidth = factor * (Math.abs(maxSantaAlonePoint.x - minSantaAlonePoint.x) + rectangleBorder) + 2*rectangleBorder;
        rectangleHeight = factor * (Math.abs(maxSantaAlonePoint.y - minSantaAlonePoint.y) + rectangleBorder) + 2*rectangleBorder;

        xOffset = Math.abs(minSantaAlonePoint.x);
        yOffset = Math.abs(maxSantaAlonePoint.y);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if (counter == 0) {
            paintRectangle(g2d);
        }

        g2d.setColor(Color.RED);
        if (counter < santaAlonePoints.size()) {
            drawPoint(g2d);
            repaint();
        }
    }

    private void drawPoint(Graphics2D g2d) {
        int x = factor * (santaAlonePoints.get(counter).x + xOffset) + rectangleX ;
        int y = factor * ((-santaAlonePoints.get(counter).y + yOffset)) + rectangleY ;
        g2d.drawOval(x, y, factor, factor);

        counter++;
        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void paintRectangle(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawRect(rectangleX-1, rectangleY-1, rectangleWidth, rectangleHeight);
    }
}

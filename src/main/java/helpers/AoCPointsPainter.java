package helpers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AoCPointsPainter extends JFrame {
    private static final boolean JFRAME_RESIZABLE = true;
    private static final Dimension DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();

    private static int rectangleX = 20;
    private static int rectangleY = 60 ;
    private static int rectangleBorder = 1;

    private String jFrameTitle = "AoC Points Drawer";
    private int sleepTime;
    private Color pointColor;


    private int rectangleWidth;
    private int rectangleHeight;

    private int xOffset;
    private int yOffset;

    private int scale;

    private ArrayList<Point> points;
    private int pointCounter = 0;


    private AoCPointsPainter(Builder builder) {
        this.points = builder.points;
        this.scale = builder.scale;
        sleepTime = builder.sleepTime;
        pointColor = builder.pointColor;
        jFrameTitle = String.format("%s - %s", jFrameTitle, builder.title);
        initJPanel();
        initJFrame();
        setupDrawArea();
    }

    private void initJPanel() {
        JPanel jPanel = new JPanel();
        add(jPanel);
        setPreferredSize(DIMENSION);
    }

    private void initJFrame() {
        setTitle(jFrameTitle);
        setSize(DIMENSION);
        setResizable(JFRAME_RESIZABLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setupDrawArea() {
        Point minEdgePoint = AoCPainterTools.getMinEdgePoint(points);
        Point maxEdgePoint = AoCPainterTools.getMaxEdgePoint(points);

        rectangleWidth = getRectangleWidth(minEdgePoint, maxEdgePoint);
        rectangleHeight = getRectangleHeight(minEdgePoint, maxEdgePoint);

        xOffset = Math.abs(minEdgePoint.x);
        yOffset = Math.abs(maxEdgePoint.y);
    }

    private int getRectangleHeight(Point minEdgePoint, Point maxEdgePoint) {
        return scale * (Math.abs(maxEdgePoint.y - minEdgePoint.y) + rectangleBorder) + 2 * rectangleBorder;
    }

    private int getRectangleWidth(Point minEdgePoint, Point maxEdgePoint) {
        return scale * (Math.abs(maxEdgePoint.x - minEdgePoint.x) + rectangleBorder) + 2 * rectangleBorder;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        if (pointCounter == 0) {
            paintRectangle(g2d);
        }

        g2d.setColor(pointColor);
        if (pointCounter < points.size()) {
            drawPoint(g2d);
            repaint();
        }
    }

    private void drawPoint(Graphics2D g2d) {
        int x = getScaledX();
        int y = getScaledY();
        g2d.fillOval(x, y, scale, scale);
        pointCounter++;

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getScaledY() {
        return scale * ((-points.get(pointCounter).y + yOffset)) + rectangleY;
    }

    private int getScaledX() {
        return scale * (points.get(pointCounter).x + xOffset) + rectangleX;
    }

    private void paintRectangle(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawRect(rectangleX-1, rectangleY-1, rectangleWidth, rectangleHeight);
    }

    /**
     * https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java
     */
    public static class Builder {

        private final ArrayList<Point> points;

        private String title = "Untitled Points";
        private Color pointColor = Color.RED;
        private int sleepTime = 5;
        private int scale = 6;

        /**
         *
         * @param title the title to be appended on the TitleBar
         * @return Builder
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         *
         * @param pointColor is the Color in which the point will be painted.
         * @return Builder
         */
        public Builder pointColor(Color pointColor) {
            this.pointColor = pointColor;
            return this;
        }

        /**
         *
         * @param points an ArrayList of points.
         */
        public Builder(ArrayList<Point> points) {
            this.points = points;
        }

        /**
         *
         * @param scale defines the scale of the paint.
         * @return Builder
         */
        public Builder scale(int scale) {
            this.scale = scale;
            return this;
        }

        /**
         *
         * @param sleepTime in milliseconds between each painted point
         * @return Builder
         */
        public Builder sleepTime(int sleepTime) {
            this.sleepTime = sleepTime;
            return this;
        }

        public AoCPointsPainter build() throws IllegalStateException {
            validate();
            return new AoCPointsPainter(this);
        }

        private void validate() throws IllegalStateException {
            StringBuilder sb = new StringBuilder();
            if (points.size() <= 0) {
                sb.append("The points have not been received.");
            }
            if (sb.length() > 0) {
                throw new IllegalStateException(sb.toString());
            }
        }
    }
}

package helpers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * Class with Methods to help in the creation of graphics from the AoC results.
 */
public class AoCGraph {

    /**
     * 
     * @param points a Collection of Points
     * @return a Point created with the minimum 'x' value,
     * and the minimum 'y' value from the Collection of Points.
     */
    public static Point getMinEdgePoint(Collection<Point> points) {

        OptionalInt minX;
        OptionalInt minY;

        minX = getMinX(points);
        minY = getMinY(points);
        
        return new Point(minX.getAsInt(), minY.getAsInt());
    }

    /**
     *
     * @param points a Collection of Points
     * @return a Point created with the maximum 'x' value,
     * and the maximum 'y' value from the Collection of Points.
     */
    public static Point getMaxEdgePoint(Collection<Point> points) {

        OptionalInt maxX;
        OptionalInt maxY;

        maxX = getMaxX(points);
        maxY = getMaxY(points);

        return new Point(maxX.getAsInt(), maxY.getAsInt());
    }

    /**
     * 
     * @param points a Collection of Points
     * @return the minimum 'x' value of all Points
     */
    public static OptionalInt getMinX(Collection<Point> points) {
        return points.stream().mapToInt(point -> point.x).min();
    }

    /**
     *
     * @param points a Collection of Points
     * @return the minimum 'y' value of all Points
     */
    public static OptionalInt getMinY(Collection<Point> points) {
        return points.stream().mapToInt(point -> point.y).min();
    }

    /**
     *
     * @param points a Collection of Points
     * @return the maximum 'x' value of all Points
     */
    public static OptionalInt getMaxX(Collection<Point> points) {
        return points.stream().mapToInt(point -> point.x).max();
    }

    /**
     *
     * @param points a Collection of Points
     * @return the maximum 'y' value of all Points
     */
    public static OptionalInt getMaxY(Collection<Point> points) {
        return points.stream().mapToInt(point -> point.y).max();
    }
    

    /**
     *
     * @param points a String collection of points in the form "x<splitRegex>y", e.g. "x,y".
     * @param splitRegex the symbol to be used to split the x and y from a String point.
     * @return an ArrayList<Point>, so it allows repeated Points.
     */
    public static ArrayList<Point> pointsListFromStrings(Collection<String> points, String splitRegex) {
        ArrayList<Point> list = (ArrayList<Point>) points.stream().
                map(point -> point.split(splitRegex)).
                map( point -> new Point(Integer.valueOf(point[0]), Integer.valueOf(point[1]))).collect(Collectors.toList());
        return list;
    }
}

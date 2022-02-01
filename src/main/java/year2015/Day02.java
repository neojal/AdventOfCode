package year2015;

import helpers.AoCUseful;

import java.io.BufferedReader;
import java.io.IOException;

public class Day02 {

    public static final String SPLIT_REGEX = "x";
    private final BufferedReader BUFFERED_READER;
    private int totalWrapper;
    private int totalRibbon;

    public Day02(BufferedReader bufferedReader) {
        BUFFERED_READER = bufferedReader;
        totalWrapper = 0;
        totalRibbon = 0;
    }

    String getWrapperAndRibbon() throws IOException {

        String inputLine;
        while ((inputLine = BUFFERED_READER.readLine()) != null) {

            int[] boxSides = AoCUseful.getSortedIntArrayFromSplit(inputLine, SPLIT_REGEX);
            totalWrapper += getBoxWrapper(boxSides);
            totalRibbon += getBoxRibbon(boxSides);
        }
        return this.toString();
    }

    private int getBoxWrapper(int[] boxSides) {
        return 2 * (boxSides[0]*boxSides[1] + boxSides[0]*boxSides[2] + boxSides[1]*boxSides[2]) +
                boxSides[0]*boxSides[1];
    }

    private int getBoxRibbon(int[] boxSides) {
        return 2 * (boxSides[0] + boxSides[1]) +
                boxSides[0] * boxSides[1] * boxSides[2];
    }

    @Override
    public String toString() {
        return "Day02{totalWrapperArea=" + totalWrapper +
                ", totalRibbonLength=" + totalRibbon +"}";
    }
}

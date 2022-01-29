package year2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Day02 {

    private final BufferedReader BUFFERED_READER;

    public Day02(BufferedReader bufferedReader) {
        BUFFERED_READER = bufferedReader;
    }

    int getTotalAreaOfWrappingPaper() throws IOException {

        String line;
        int totalArea = 0;
        while ((line = BUFFERED_READER.readLine()) != null) {

            int[] dimensions = new int[3];
            int boxArea = 0;
            int smallestSide = 0;
            int position = 0;
            StringTokenizer st = new StringTokenizer(line, "x");
            while (st.hasMoreTokens()) {
                dimensions[position] = Integer.parseInt(st.nextToken());

                if (position > 0) {
                    for (int j = position - 1; j >= 0; j--) {
                        int side = 2 * (dimensions[position] * dimensions[j]);
                        boxArea += side;
                        smallestSide = getSmallestSide(smallestSide, side);
                    }
                }
                position++;
            }
            totalArea += getTotalBoxArea(boxArea, smallestSide);
        }
        return totalArea;
    }

    private int getTotalBoxArea(int boxArea, int smallestSide) {
        return boxArea + smallestSide / 2;
    }

    private int getSmallestSide(int smallestSide, int side) {
        return smallestSide == 0 ? side : Math.min(side, smallestSide);
    }
}

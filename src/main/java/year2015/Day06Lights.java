package year2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public abstract class Day06Lights {

    protected static final String TOGGLE = "toggle";
    private static final String TURN = "turn";
    protected static final String ON = "on";

    private final BufferedReader bufferedReader;
    private final int[][] lightsGrid;

    public Day06Lights(BufferedReader bufferedReader) {
        lightsGrid = new int[1000][1000];
        this.bufferedReader = bufferedReader;
    }

    public int getTotalBrightnessNumber() throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            processInstructionPart1(line);
        }
        return countLightsLit();
    }

    
    private int countLightsLit() {
        return Arrays.asList(lightsGrid).
                parallelStream().
                flatMapToInt(Arrays::stream).
                filter(light -> light>0).
                sum();
    }

    /**
     *
     * @param line String line of the form "turn off 370,39 through 425,839"
     */
    private void processInstructionPart1(String line) {
        String instruction = null;
        int[] firstCorner = new int[2];
        int[] secondCorner = new int[2];

        StringTokenizer st = new StringTokenizer(line);
        while (st.hasMoreTokens()) {
            instruction = getInstruction(st);
            firstCorner = getCorner(st.nextToken());
            st.nextToken();
            secondCorner = getCorner(st.nextToken());
        }
        executeLightControl(instruction, firstCorner, secondCorner);
    }

    private void executeLightControl(String instruction, int[] firstCorner, int[] secondCorner) {
        for (int i = firstCorner[0]; i <= secondCorner[0]; i++) {
            for (int j = firstCorner[1]; j <= secondCorner[1]; j++) {
                lightsGrid[i][j] = setNewLightValue(instruction, lightsGrid[i][j]);
            }
        }
    }

    abstract protected int setNewLightValue(String instruction, int i);

    private int[] getCorner(String corner) {
        return Arrays.stream(corner.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    private String getInstruction(StringTokenizer st) {
        return isTurnInstruction(st) ? st.nextToken() : TOGGLE;
    }

    private boolean isTurnInstruction(StringTokenizer st) {
        return st.nextToken().equals(TURN);
    }
}

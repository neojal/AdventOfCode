package helpers;

import java.util.Arrays;

public class AoCTransformData {

    public static int[] getSortedIntArrayFromSplit(String line, String regex) {
        return Arrays.stream(line.split(regex)).mapToInt(Integer::parseInt).sorted().toArray();
    }
}

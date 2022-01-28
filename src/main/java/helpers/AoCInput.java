package helpers;

import java.io.*;

public class AoCInput {

    public static final int EOF = -1;

    public static InputStream getInputStream(String filePath) {
        InputStream resourceAsStream = AoCInput.class.getClassLoader().getResourceAsStream(filePath);
        return resourceAsStream;
    }

    public static boolean isNotEof(int c) {
        return c != EOF;
    }
}

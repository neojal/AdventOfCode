package helpers;

import java.io.*;

public class InputFileReader {

    private final InputStream inputStream;

    public InputFileReader(String filePath) {
        inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
    }

    public InputStream getInputStream() {
        return inputStream;
    }
}

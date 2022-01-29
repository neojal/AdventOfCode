package helpers;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AoCInput {

    private static final int EOF = -1;
    private final URI uri;

    public AoCInput(String inputFilePath) throws URISyntaxException {
        URL url = AoCInput.class.getClassLoader().getResource(inputFilePath);
        assert url != null;
        uri = url.toURI();
    }

    public InputStream getInputStream() throws FileNotFoundException {
        File file = new File(uri);
        return new FileInputStream(file);
    }

    public BufferedReader getBufferedReader() throws IOException {
        Path path = Paths.get(uri);
        return Files.newBufferedReader(path);
    }

    public static boolean isNotEof(int c) {
        return c != EOF;
    }
}

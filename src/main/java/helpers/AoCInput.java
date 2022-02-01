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
    private static URI uri;

    private AoCInput(String inputFilePath) throws URISyntaxException {
        URL url = AoCInput.class.getClassLoader().getResource(inputFilePath);
        assert url != null;
        uri = url.toURI();
    }

    /**
     *
     * @param inputFilePath
     * @return an {@link InputStream} to read char by char.
     * @throws FileNotFoundException
     * @throws URISyntaxException
     */
    public static InputStream getInputStream(String inputFilePath) throws FileNotFoundException, URISyntaxException {
        new AoCInput(inputFilePath);
        File file = new File(uri);
        return new FileInputStream(file);
    }

    /**
     *
     * @param inputFilePath
     * @return a {@link BufferedReader} to read line by line.
     * @throws IOException
     * @throws URISyntaxException
     */
    public static BufferedReader getBufferedReader(String inputFilePath) throws IOException, URISyntaxException {
        new AoCInput(inputFilePath);
        Path path = Paths.get(uri);
        return Files.newBufferedReader(path);
    }

    /**
     *
     * @param c
     * @return true if the char is not the EOF
     */
    public static boolean isNotEof(int c) {
        return c != EOF;
    }
}

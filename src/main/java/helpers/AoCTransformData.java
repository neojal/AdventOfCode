package helpers;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AoCTransformData {

    public static int[] getSortedIntArrayFromSplit(String line, String regex) {
        return Arrays.stream(line.split(regex)).mapToInt(Integer::parseInt).sorted().toArray();
    }

    public static String getMD5HashFromSecret(String secret) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(secret.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }
}

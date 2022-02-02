package helpers;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AoCUseful {



    /**
     *
     * @param line a String to split, e.g. "x,y,z..."
     * @param regex a String to be used as splitter, e.g. ','
     * @return
     */
    public static int[] getSortedIntArrayFromSplit(String line, String regex) {
        return Arrays.stream(line.split(regex)).mapToInt(Integer::parseInt).sorted().toArray();
    }

    /**
     *
     * @param secret String to be MD5 hashed
     * @return the MD5 hash of the secret String param
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5HashFromSecret(String secret) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(secret.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest);
    }

}

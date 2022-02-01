package year2015;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day04 {
    public int md5Generator(String secret) throws NoSuchAlgorithmException {
        boolean result;

        int n = 0;

        do {
            result = getPart1(String.format("%s%d", secret, n++));
        } while (!result);

        return n - 1;
    }

    private boolean getPart1(String secret) throws NoSuchAlgorithmException {
        String hash = getMD5HashFromSecret(secret);
        if (hash.startsWith("00000")) {
            return true;
        }
        return false;
    }

    public String getMD5HashFromSecret(String secret) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(secret.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }
}

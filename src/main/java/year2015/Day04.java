package year2015;

import helpers.AoCTransformData;

import java.security.NoSuchAlgorithmException;

public class Day04 {

    public int getNumberWithCondition(String secret, String condition) throws NoSuchAlgorithmException {
        int n = -1;
        String hash;
        do {
            String newSecret = secret.concat(Integer.toString(++n));
            hash = AoCTransformData.getMD5HashFromSecret(newSecret);
        } while (!hash.startsWith(condition));
        return n;
    }
}

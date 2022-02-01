package helpers;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AoCUseful {

    public static final String LOW_VOWELS = "aeiou";

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

    /**
     *
     * @param word
     * @return the number of vowels found in the String word param
     */
    public static int countVowels(String word) {
        word = word.toLowerCase();
        int vowelCounter = 0;

        for (int i=0; i < word.length(); i++) {
            if (LOW_VOWELS.contains(Character.toString(word.charAt(i)))) {
                vowelCounter++;
            }
        }
        return vowelCounter;
    }

    /**
     *
     * @param s Is a String to be evaluated if contains any repeats characters.
     * @param repeats Is the number of repeated characters required to look for.
     * @return a List with all the repeated characters
     */
    public static Map<Character, Integer> consecutiveEqualChars(String s, int repeats) {
        Map<Character, Integer> repeatedChars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int counter = 1;
            Character c = s.charAt(i);
            for (int j = i + 1; (j <= i + repeats) && (j < s.length()); j++) {
                if (c == s.charAt(j)) {
                    counter++;
                } else {
                    break;
                }
            }
            if (counter >= repeats) {
                if (repeatedChars.containsKey(c)) {
                    repeatedChars.put(c, repeatedChars.get(c)+1);
                } else {
                    repeatedChars.put(c, 1);
                }
            }
        }
        return repeatedChars;
    }



    /**
     *
     * @param s
     * @param subStrings
     * @return true If the String s contains any of the subStrings
     */
    public static boolean containsAnySubStrings(String s, String[] subStrings) {
        for (String forbiddenString : subStrings) {
            if (s.contains(forbiddenString)) {
                return true;
            }
        }
        return false;
    }
}

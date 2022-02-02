package year2015;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class Day05 {

    private static final String[] FORBIDDEN_STRINGS = {"ab", "cd", "pq", "xy"};
    private static final String LOW_VOWELS = "aeiou";

    private final BufferedReader bufferedReader;

    public Day05(BufferedReader bufferedReader) {
        if (bufferedReader == null) {
            throw new IllegalArgumentException("Parameter BufferedReader bufferedReader is null");
        }
        this.bufferedReader = bufferedReader;
    }

    public long getNumberOfNiceStringsPart1() {
        return bufferedReader.lines().parallel().
                filter(s -> countVowels(s) >= 3).
                filter(s -> getConsecutiveEqualCharRepetitions(s, 2).size() > 0).
                filter(s -> !containsAnySubStrings(s, FORBIDDEN_STRINGS)).count();
    }

    public long getNumberOfNiceStringsPart2() {
        return bufferedReader.lines().parallel().
                filter(s -> getRepeatedSubstrings(s, 2).size() > 0).
                filter(this::containsCharSandwich).
                count();
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
     * @param s Is a String to be evaluated if contains any consecutive repeated characters.
     * @param repeats Is the number of consecutive repeated characters to look for.
     * @return a Map with all the repeated characters and the number of repetitions
     */
    public static Map<Character, Integer> getConsecutiveEqualCharRepetitions(String s, int repeats) {
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
     * @param s the string that may contain some repeated subStrings, e.g. aaabcdeaa
     * @param subStringLength is the length of the substrings to search for repetition, e.g. 2
     * @return the repeated subStrings with its appearances , e.g. "aa" appears twice: {aa=2}
     */
    public static Map<String, Integer> getRepeatedSubstrings(String s, int subStringLength) {
        Map<String, Integer> results = new HashMap<>();
        for (int i = 0; i < s.length()-subStringLength; i++) {
            String look = s.substring(i, i+subStringLength);
            if (s.substring(i+subStringLength).contains(look)) {
                int number = 1;
                if (results.containsKey(look)) {
                    number += results.get(look);
                }
                results.put(look, number);
            }
        }
        return results;
    }

    /**
     *
     * @param s
     * @param subStrings
     * @return true If the String s contains any of the subStrings
     */
    public static boolean containsAnySubStrings(String s, String @NotNull [] subStrings) {
        for (String subString : subStrings) {
            if (s.contains(subString)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param s the String to be evaluated: e.g. "abcdedc"
     * @return this is a char sandwich: "ded", 'd' is the bread, 'e' is the filling.
     */
    public boolean containsCharSandwich(@NotNull String s) {
        for (int bottomBread=0; bottomBread < s.length()-2; bottomBread++) {
            int upperBread = bottomBread+3;
            String sub = s.substring(bottomBread, upperBread);
            if (sub.charAt(0) == sub.charAt(2)) {
                return true;
            }
        }
        return false;
    }
}

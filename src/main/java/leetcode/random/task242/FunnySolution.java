package leetcode.random.task242;

import java.util.Arrays;

/**
 * Faster then HashMap
 */
public class FunnySolution {
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        String sSorted = new String(sChars);
        String tSorted = new String(tChars);
        return sSorted.equals(tSorted);
    }
}

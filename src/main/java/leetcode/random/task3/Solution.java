package leetcode.random.task3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int out = 0;
        for (int i = 0, j = 0; j < s.length(); ) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            set.add(s.charAt(j++));
            out = Math.max(out, j - i);
        }
        return out;
    }
}

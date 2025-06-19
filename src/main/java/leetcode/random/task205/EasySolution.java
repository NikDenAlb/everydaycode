package leetcode.random.task205;

import java.util.HashMap;
import java.util.Map;

class EasySolution {
    boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map1.putIfAbsent(s.charAt(i), i);
            map2.putIfAbsent(t.charAt(i), i);
            if (map1.get(s.charAt(i)) != map2.get(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

package leetcode.random.task242;

import java.util.HashMap;
import java.util.Map;

class EasySolution {
    boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.merge(s.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < t.length(); i++) {
            mapT.merge(t.charAt(i), 1, Integer::sum);
        }
        return mapS.equals(mapT);
    }
}

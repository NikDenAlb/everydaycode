package leetcode.random.task1657;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EasySolution {
    boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }
        List<Integer> vals1 = new ArrayList<>(map1.values());
        List<Integer> vals2 = new ArrayList<>(map2.values());
        Collections.sort(vals1);
        Collections.sort(vals2);
        return vals1.equals(vals2);
    }
}

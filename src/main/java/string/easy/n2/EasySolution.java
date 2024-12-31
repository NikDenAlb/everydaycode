package string.easy.n2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EasySolution implements Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), words[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(words[i])) return false;
            }
        }

        return new HashSet<>(map.values()).size() == map.size();
    }
}

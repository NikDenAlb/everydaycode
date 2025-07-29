package leetcode.random.task383;

import java.util.HashMap;
import java.util.Map;

class EasySolution {
    boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mgz = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            mgz.put(magazine.charAt(i), mgz.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!mgz.containsKey(ransomNote.charAt(i)) || mgz.get(ransomNote.charAt(i)) == 0) {
                return false;
            }
            mgz.merge(ransomNote.charAt(i), -1, Integer::sum);
        }
        return true;
    }
}

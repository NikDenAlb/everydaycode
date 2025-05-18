package leetcode.random.task345;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class EasySolution {
    String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        List<Integer> idxs = new ArrayList<>();
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                chars.add(s.charAt(i));
                idxs.add(i);
            }
        }
        StringBuilder out = new StringBuilder(s);
        for (int i = 0; i < chars.size(); i++) {
            out.setCharAt(idxs.get(i), chars.get(chars.size() - 1 - i));
        }
        return out.toString();
    }
}

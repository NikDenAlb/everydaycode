package leetcode.random.task1456;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class EasySolution {
    int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int[] isVowels = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                isVowels[i] = 1;
            }
        }
        int sum = 0, out = 0;
        for (int i = 0; i < k && i < isVowels.length; i++) {
            sum += isVowels[i];
        }
        out = sum;
        for (int i = k; i < isVowels.length; i++) {
            sum -= isVowels[i-k];
            sum += isVowels[i];
            out = Math.max(out, sum);
        }
        return out;
    }
}

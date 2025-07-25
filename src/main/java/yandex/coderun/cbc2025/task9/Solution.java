package yandex.coderun.cbc2025.task9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] solve(int n, String[] words) {
        int[][] result = new int[n][2];
        for (int i = 0; i < n; ++i) {
            result[i] = new int[2];
        }
        //-------------
        List<Pair> pairs = new ArrayList<>(words.length);
        for (int i = 0; i < words.length; i++) {
            pairs.add(new Pair(i + 1, words[i]));
        }
        pairs.sort(Comparator.comparing(Pair::word));

        int cnt = 0;
        while (cnt < n) {
            for (int i = pairs.size() - 1, j = pairs.size() - 2; ; i--, j--) {
                Pair a = pairs.get(i);
                Pair b = pairs.get(j);
                if (a.word.length() >= b.word.length() && a.word.startsWith(b.word)) {
                    result[cnt][0] = b.index;
                    result[cnt][1] = a.index;
                    cnt++;
                    pairs.remove(j);
                    pairs.remove(j);
                    break;
                }
            }
        }
        return result;
    }

    record Pair(int index, String word) {
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ans = solution.solve(2, new String[]{"abac", "abacab", "aba", "abaa"});
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
        System.out.println("------------");
        ans = solution.solve(3, new String[]{"abac", "abacab", "aba", "abaa", "ffff", "ff"});
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }
}
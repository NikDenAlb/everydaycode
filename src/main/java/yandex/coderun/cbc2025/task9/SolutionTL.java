package yandex.coderun.cbc2025.task9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class SolutionTL {
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
        pairs.sort(Comparator.comparingInt((Pair e) -> e.word().length()).reversed());
        int out = 0;
        boolean[] used = new boolean[pairs.size()];
        for (int i = 0; out < n; i++) {
            if (used[i]) {
                continue;
            }
            Pair a = pairs.get(i);
            for (int j = i + 1; true; j++) {
                if (used[j]) {
                    continue;
                }
                Pair b = pairs.get(j);
                if (a.word.startsWith(b.word)) {
                    result[out][0] = b.index;
                    result[out][1] = a.index;
                    used[j] = true;
                    out++;
                    break;
                }
            }
        }
        return result;
    }

    record Pair(int index, String word) {
    }

    public static void main(String[] args) {
        SolutionTL solution = new SolutionTL();
        int[][] ans = solution.solve(2, new String[]{"abac", "abacab", "aba", "abaa"});
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }
}
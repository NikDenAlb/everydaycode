package yandex.coderun.cbc2025.task9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    public int[][] solve(int n, String[] words) {
        int[][] result = new int[n][2];
        for (int i = 0; i < n; ++i) {
            result[i] = new int[2];
        }
        //---------------

        Map<String, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i + 1);
            } else {
                map.put(words[i], new ArrayDeque<>(List.of(i + 1)));
            }
        }
        List<Map.Entry<String, Deque<Integer>>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparing(e -> e.getKey().length()));

        List<Deque<Map.Entry<String, Deque<Integer>>>> lists = new ArrayList<>();
        for (Map.Entry<String, Deque<Integer>> entry : list) {
            if (entry.getValue().size() == 1) {
                lists.add(new ArrayDeque<>(List.of(entry)));
                continue;
            }
            boolean found = false;
            for (Deque<Map.Entry<String, Deque<Integer>>> line : lists) {
                if (entry.getKey().startsWith(line.getLast().getKey())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                lists.add(new ArrayDeque<>(List.of(entry)));
            }
        }

        int cnt = -1;
        int indx = -1;
        for (Deque<Map.Entry<String, Deque<Integer>>> line : lists) {
            while (!line.isEmpty()) {
                Deque<Integer> a = line.pollLast().getValue();
                while (!a.isEmpty()) {
                    result[++cnt / 2][++indx % 2] = a.pollLast();
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
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
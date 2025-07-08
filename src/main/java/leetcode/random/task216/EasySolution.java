package leetcode.random.task216;

import java.util.ArrayList;
import java.util.List;

class EasySolution {
    List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        k--;
        for (int i = 1; i <= 9 - k; i++) {
            if (i < n) {
                lists.add(new ArrayList<>(List.of(i)));
            }
        }
        k--;
        while (k > 0 && !lists.isEmpty()) {
            List<List<Integer>> nextLists = new ArrayList<>();
            for (List<Integer> list : lists) {
                int sum = list.stream().mapToInt(i -> i).sum();
                for (int i = list.getLast() + 1; i <= 9 - k; i++) {
                    if (i + sum < n) {
                        List<Integer> next = new ArrayList<>(list);
                        next.add(i);
                        nextLists.add(next);
                    } else {
                        break;
                    }
                }
            }
            lists = nextLists;
            k--;
        }
        if (!lists.isEmpty()) {
            List<List<Integer>> nextLists = new ArrayList<>();
            for (List<Integer> list : lists) {
                int sum = list.stream().mapToInt(i -> i).sum();
                for (int i = list.getLast() + 1; i <= 9; i++) {
                    if (i + sum == n) {
                        List<Integer> next = new ArrayList<>(list);
                        next.add(i);
                        nextLists.add(next);
                        break;
                    }
                }
            }
            lists = nextLists;
        }
        return lists;
    }
}

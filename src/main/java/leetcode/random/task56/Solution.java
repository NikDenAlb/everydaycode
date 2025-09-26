package leetcode.random.task56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> list = new ArrayList<>();
        int a = intervals[0][0];
        int b = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= b) {
                b = Math.max(b, intervals[i][1]);
            } else {
                list.add(new ArrayList<>(List.of(a, b)));
                a = intervals[i][0];
                b = intervals[i][1];
            }
        }
        list.add(new ArrayList<>(List.of(a, b)));
        int[][] out = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            List<Integer> iList = list.get(i);
            out[i] = new int[2];
            out[i][0] = iList.getFirst();
            out[i][1] = iList.getLast();
        }
        return out;
    }
}
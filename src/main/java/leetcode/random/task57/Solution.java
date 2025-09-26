package leetcode.random.task57;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> out = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            out.add(intervals[i]);
            i++;
        }

        if (i < intervals.length) newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        out.add(newInterval);

        while (i < intervals.length) {
            out.add(intervals[i]);
            i++;
        }

        return out.toArray(new int[out.size()][2]);
    }
}
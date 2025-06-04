package leetcode.random.task2352;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class EasySolution {
    int equalPairs(int[][] grid) {
        int count = 0;
        Map<Array, Integer> rows = new HashMap<>();
        for (int[] ints : grid) {
            Array arr = new Array(ints);
            rows.put(arr, rows.getOrDefault(arr, 0) + 1);
        }
        for (int i = 0; i < grid.length; i++) {
            int[] col = new int[grid.length];
            for (int j = 0; j < col.length; j++) {
                    col[j] = grid[j][i];
            }
            Array arr = new Array(col);
            count += rows.getOrDefault(arr, 0);
        }
        return count;
    }

    record Array(int[] arr) {
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;

            Array array = (Array) o;
            return Arrays.equals(arr, array.arr);
        }

        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }
}

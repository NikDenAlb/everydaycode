package yandex.coderun.cbc2025.task5;

import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/erased-leaderboard">task link</a><br>
 * test - OK
 */
public class Solution {
    public int[] solve(int n, int m, int[] p) {
        if (p[0] == -1) {
            p[0] = m;
        }
        for (int i = 1; i < p.length; i++) {
            if (p[i] == -1) {
                p[i] = p[i - 1] + m;
                if (p[i] < p[i - 1]) {
                    return new int[]{-1};
                }
                continue;
            }
            if (p[i] < p[i - 1] + m) {
                return new int[]{-1};
            }
        }

        int[] out = new int[n];
        out[0] = p[0];
        for (int i = 1; i < out.length; i++) {
            out[i] = p[i] - p[i - 1];
        }

        return out;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solve(3, 1, new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution.solve(2, 0, new int[]{-1, -1,})));
        System.out.println(Arrays.toString(solution.solve(4, 2, new int[]{2, -1, -1, 5})));
    }
}

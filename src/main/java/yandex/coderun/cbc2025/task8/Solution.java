package yandex.coderun.cbc2025.task8;

import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/favorite-melodies">task link</a><br>
 * test - OK
 */
public class Solution {
    public long solve(int n, int q, long[] a, int[][] queries) {
        long[] frq = new long[n + 1];
        for (int[] query : queries) {
            frq[query[0] - 1]++;
            frq[query[1]]--;
        }
        long curr = frq[0];
        for (int i = 1; i < frq.length - 1; i++) {
            curr += frq[i];
            frq[i] = curr;
        }
        Arrays.sort(frq);
        Arrays.sort(a);
        long out = 0;
        int aEnd = a.length - 1;
        for (int i = frq.length - 1; i >= 0 && frq[i] > 0; i--) {
            out += frq[i] * a[aEnd--];
        }
        return out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(3, 4, new long[]{7, 3, 1}, new int[][]{{1, 3}, {2, 3}, {3, 3}, {2, 2}}));
        System.out.println(solution.solve(4, 4, new long[]{1, 100, 10000, 10101010}, new int[][]{{1, 4}, {2, 3}, {2, 2}, {1, 2}}));
    }
}

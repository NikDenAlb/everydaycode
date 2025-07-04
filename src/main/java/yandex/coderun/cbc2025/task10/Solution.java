package yandex.coderun.cbc2025.task10;

import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/sudden-storm">task link</a><br>
 * test - OK
 */
class Solution {
    public long[] solve(int n, int t, long[] a, long[] b) {
        long[] result = new long[t + 1];

        result[0] = Arrays.stream(a).sum();
        long spd = Arrays.stream(b).sum();

        long[] lowingSpd = new long[t];
        for (int i = 0; i < n; i++) {
            if (b[i] == 0) {
                continue;
            }
            long indx = a[i] / b[i];
            if (indx < t) {
                long minus1 = b[i] - a[i] % b[i];
                lowingSpd[(int) indx] += minus1;
                if (++indx < t) {
                    lowingSpd[(int) indx] += b[i] - minus1;
                }
            }
        }
        for (int i = 0; i < t; i++) {
            spd -= lowingSpd[i];
            result[i + 1] = result[i] - spd;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solve(6, 6, new long[]{12, 10, 3, 5, 7, 9}, new long[]{2, 3, 1, 4, 2, 1})));
        System.out.println(Arrays.toString(solution.solve(3, 5, new long[]{10, 20, 30}, new long[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution.solve(3, 5, new long[]{1, 3, 30}, new long[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution.solve(1, 1, new long[]{1}, new long[]{1})));
    }
}
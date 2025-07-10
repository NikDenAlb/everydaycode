package yandex.coderun.cbc2025.task11;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/sheep-wolf">task link</a><br>
 * test - OK
 */
public class Solution {
    public long solve(int n, long[] a) {
        if (n == 1) {
            return 0;
        }
        long a1 = a[0];
        long a2 = Integer.MIN_VALUE;
        int out = 0;
        int j = 1;
        int i1n = 0;
        int i2n = -1;
        for (; j < a.length; j++) {
            if (a[j] != a1) {
                a2 = a[j];
                out = j + 1;
                i1n = j;
                j++;
                i2n = j;
                break;
            }
        }
        if (a2 == Integer.MIN_VALUE) {
            return 0;
        }
        int i = 0;
        for (; j < a.length; j++) {
            if (a[j] != a1 && a[j] != a2) {
                out = Math.max(out, j - i);
                i = Math.min(i1n, i2n);
                i1n = i + 1;
                a1 = a[i];
                i2n = j + 1;
                a2 = a[j];
            } else {
                if (a[j] == a1) {
                    i1n = j + 1;
                } else {
                    i2n = j + 1;
                }
            }
        }
        out = Math.max(out, j - i);
        return out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(6, new long[]{3, 3, 1, 2, 2, 1}));
        System.out.println(solution.solve(6, new long[]{3, 1, 8, 2, 1, 1}));
        System.out.println(solution.solve(2, new long[]{1, 1}));
        System.out.println(solution.solve(2, new long[]{1, 2}));
        System.out.println(solution.solve(12, new long[]{3, 3, 1, 2, 2, 1, 20, 100, 1, 1, 1, 100}));
    }
}

package yandex.coderun.cbc2025.task4;

import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/stairs">task link</a><br>
 * test - OK
 */
public class Solution {
    public int[] solve(int n, int[] a) {
        int[] result = new int[n + 1];

        a = Arrays.stream(a).map(Math::abs).toArray();

        int i = 1;
        for (; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                break;
            }
            result[i] = -a[i - 1];
        }
        for (; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return result;
            }
            result[i] = a[i - 1];
        }
        result[i] = a[i - 1];

        result[0] = 1;
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solve(5, new int[]{1, -1, -2, 3, 6})));
        System.out.println(Arrays.toString(solution.solve(3, new int[]{1, 1, 0})));
    }
}

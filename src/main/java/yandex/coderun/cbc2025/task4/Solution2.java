package yandex.coderun.cbc2025.task4;

import java.util.Arrays;

public class Solution2 {
    public int[] solve(int n, int[] a) {
        int[] result = new int[n + 1];

        a = Arrays.stream(a).map(Math::abs).sorted().toArray();
        for (int i = 0; i < a.length - 2; i++) {
            if (a[i] == a[i + 1] && a[i] == a[i + 2] || a[i] == 0 && a[i] == a[i + 1]) {
                return result;
            } else if (a[i] == a[i + 1]) {
                a[i] = -a[i];
            }
        }
        if (a[a.length - 2] == a[a.length - 1]) {
            if (a[a.length - 2] == 0) {
                return result;
            } else {
                a[a.length - 2] = -a[a.length - 2];
            }
        }

        Arrays.sort(a);
        System.arraycopy(a, 0, result, 1, n);
        result[0] = 1;

        return result;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.solve(5, new int[]{1, -1, -2, 3, 6})));
        System.out.println(Arrays.toString(solution.solve(3, new int[]{1, 1, 0})));
    }
}

package yandex.coderun.cbc2025.task2;

import java.util.Arrays;

class Solution {
    public int solve(int n, int[] a) {
        Arrays.sort(a);
        int mC = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[i] + n - 1) {
                    break;
                }
                count++;
            }
            if (mC < count) {
                mC = count;
            }
        }
        return n - mC;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(5, new int[]{2, 0, -3, 3, 6}));
        System.out.println(solution.solve(1, new int[]{25}));
    }
}

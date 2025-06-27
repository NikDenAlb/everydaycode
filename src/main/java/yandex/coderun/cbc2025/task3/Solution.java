package yandex.coderun.cbc2025.task3;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/commotion-in-the-guard">task link</a><br>
 * test - OK
 */
public class Solution {
    public int[] solve(int n, int m, int[] swaps) {
        int[] result = new int[m];
        int[] arr = new int[2 * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int r = n;
        for (int i = 0; i / 2 < m; i += 2) {
            if (swaps[i] <= n && swaps[i + 1] > n) {
                if (arr[swaps[i] - 1] <= n && arr[swaps[i + 1] - 1] > n) {
                    r--;
                } else if (arr[swaps[i] - 1] > n && arr[swaps[i + 1] - 1] <= n) {
                    r++;
                }
            } else if (swaps[i] > n && swaps[i + 1] <= n) {
                if (arr[swaps[i] - 1] <= n && arr[swaps[i + 1] - 1] > n) {
                    r++;
                } else if (arr[swaps[i] - 1] > n && arr[swaps[i + 1] - 1] <= n) {
                    r--;
                }
            }
            int tmp = arr[swaps[i] - 1];
            arr[swaps[i] - 1] = arr[swaps[i + 1] - 1];
            arr[swaps[i + 1] - 1] = tmp;
            result[i / 2] = r;
        }
        return result;
    }
}

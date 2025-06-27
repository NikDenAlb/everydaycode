package yandex.coderun.cbc2025.task3;

public class SolutionPrimitive {
    public int[] solve(int n, int m, int[] swaps) {
        int[] arr = new int[2 * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int[] result = new int[m];
        for (int i = 0; i / 2 < m; i += 2) {
            int tmp = arr[swaps[i] - 1];
            arr[swaps[i] - 1] = arr[swaps[i + 1] - 1];
            arr[swaps[i + 1] - 1] = tmp;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] <= n) {
                    count++;
                }
            }
            result[i / 2] = count;
        }
        return result;
    }
}

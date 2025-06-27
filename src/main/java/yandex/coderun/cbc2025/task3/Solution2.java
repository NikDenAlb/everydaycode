package yandex.coderun.cbc2025.task3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Don't see why it's not working
 */
public class Solution2 {
    public int[] solve(int n, int m, int[] swaps) {
        int[] result = new int[m];
        Set<Integer> setL = new HashSet<>();
        Set<Integer> setR = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            setL.add(i);
        }
        for (int i = 0; i / 2 < m; i += 2) {
            if (swaps[i] != swaps[i + 1]) {
                if (setL.contains(swaps[i]) && setR.contains(swaps[i + 1])) {
                    setL.add(swaps[i + 1]);
                    setL.remove(swaps[i]);
                    setR.add(swaps[i]);
                    setR.remove(swaps[i + 1]);
                } else if (setL.contains(swaps[i + 1]) && setR.contains(swaps[i])) {
                    setL.add(swaps[i]);
                    setL.remove(swaps[i + 1]);
                    setR.add(swaps[i + 1]);
                    setR.remove(swaps[i]);
                } else if (setL.contains(swaps[i]) && !setL.contains(swaps[i + 1]) && !setR.contains(swaps[i + 1])) {
                    setL.remove(swaps[i]);
                    setR.add(swaps[i + 1]);
                } else if (setL.contains(swaps[i + 1]) && !setL.contains(swaps[i]) && !setR.contains(swaps[i])) {
                    setL.remove(swaps[i + 1]);
                    setR.add(swaps[i]);
                } else if (!setL.contains(swaps[i]) && setR.contains(swaps[i + 1]) && !setR.contains(swaps[i])) {
                    setL.add(swaps[i]);
                    setR.remove(swaps[i + 1]);
                } else if (!setL.contains(swaps[i + 1]) && setR.contains(swaps[i]) && !setR.contains(swaps[i + 1])) {
                    setL.add(swaps[i + 1]);
                    setR.remove(swaps[i]);
                }
            }
            result[i / 2] = setL.size();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solve(3, 3, new int[]{5, 6, 2, 5, 6, 5})));

        System.out.println(Arrays.toString(solution.solve(3, 3, new int[]{5, 6, 2, 5, 6, 5})));
        System.out.println(Arrays.toString(solution.solve(3, 3, new int[]{5, 6, 2, 5, 6, 5})));
        System.out.println(Arrays.toString(solution.solve(3, 3, new int[]{5, 6, 2, 5, 6, 5})));
    }
}

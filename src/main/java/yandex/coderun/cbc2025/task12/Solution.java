package yandex.coderun.cbc2025.task12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solve(int n, int k, int[] a) {
        if (n <= 2) {
            return new int[]{1, n};
        }
        if (k == 0) {
            return new int[]{1, n};
        }
        int j = n == a[a.length - 1] ? k - 2 : k - 1;
        List<Integer> preOut = new ArrayList<>();
        while (j > 0) {
            if (a[j] == n - 2) {
                j--;
                n -= 2;
                preOut.add(2);
            } else if (a[j - 1] == n - 2) {
                j -= 2;
                n -= 2;
                preOut.add(2);
            } else if (a[j] == n - 1) {
                j--;
                n--;
                preOut.add(1);
            } else {
                return new int[]{-1};
            }
        }
        if (j == 0) {
            if (n != 2 && n!= 1) {
                if (a[0] == n - 2) {
                    preOut.add(2);
                    n -= 2;
                } else if (a[0] == n - 1) {
                    preOut.add(1);
                    n--;
                } else {
                    return new int[]{-1};
                }
            }
        }
        if (n == 1 || n == 2) {
            preOut.add(n);
        } else {
            return new int[]{-1};
        }

        int[] out = new int[preOut.size() + 1];
        out[0] = preOut.size();
        for (int i = 0; i < preOut.size(); i++) {
            out[out.length - 1 - i] = preOut.get(i);
        }
        return out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solve(5, 3, new int[]{2, 3, 4})));
        //3, 2, 1, 2
        System.out.println(Arrays.toString(solution.solve(7, 3, new int[]{2, 3, 4})));
        //-1
        System.out.println(Arrays.toString(solution.solve(2, 1, new int[]{1})));
        //1, 2
        System.out.println(Arrays.toString(solution.solve(10, 8, new int[]{2, 3, 4, 5, 6, 7, 8, 9})));
        //5, 2, 2, 2, 2, 2
        System.out.println(Arrays.toString(solution.solve(10, 5, new int[]{1, 3, 5, 7, 9})));
        //6, 1, 2, 2, 2, 2, 1
        System.out.println(Arrays.toString(solution.solve(10, 2, new int[]{5, 10})));
        //-1
        System.out.println(Arrays.toString(solution.solve(7, 4, new int[]{1, 2, 4, 6})));
        //[4, 2, 2, 2, 1]
        System.out.println(Arrays.toString(solution.solve(6, 4, new int[]{1, 2, 3, 5})));
        //[4, 1, 2, 2, 1]
        System.out.println(Arrays.toString(solution.solve(3, 2, new int[]{1, 3})));
        //[2, 1, 2]
        System.out.println(Arrays.toString(solution.solve(2, 1, new int[]{1})));
        //[1, 2]
    }
}


//[*][][1]
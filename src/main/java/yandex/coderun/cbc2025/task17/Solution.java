package yandex.coderun.cbc2025.task17;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/city-wall-destruction">task link</a><br>
 * test - OK
 */
public class Solution {
    public long solve(int n, long[] a) {
        int[] minR = new int[n];
        int[] maxR = new int[n];
        int[] minL = new int[n];
        int[] maxL = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] > a[i]) {
                minR[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            minR[stack.pop()] = n;
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                maxR[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            maxR[stack.pop()] = n;
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[stack.peek()] > a[i]) {
                minL[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            minL[stack.pop()] = -1;
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                maxL[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            maxL[stack.pop()] = -1;
        }

        long out = 0;
        for (int i = 0; i < n; i++) {
            long indMaxPower = (long) (i - maxL[i]) * (long) (maxR[i] - i);
            long indMinPower = (long) (i - minL[i]) * (long) (minR[i] - i);
            out += (indMaxPower - indMinPower) * a[i];
        }
        return out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(1, new long[]{1}));
        //0
        System.out.println(solution.solve(2, new long[]{1, 11}));
        //10
        System.out.println(solution.solve(3, new long[]{1, 3, 5}));
        //8
        System.out.println(solution.solve(4, new long[]{1, 3, 5, 2}));
        //18
        System.out.println(solution.solve(6, new long[]{1, 4, 10, 2, 12, 200}));
        //1065
    }
}


// 2+2+$
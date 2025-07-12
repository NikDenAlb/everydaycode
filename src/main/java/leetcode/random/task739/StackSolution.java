package leetcode.random.task739;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * My solution, was no need in PriorityQueue
 */
public class StackSolution {
    int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] out = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int ind = stack.poll();
                out[ind] = i - ind;
            }
            stack.push(i);
        }
        return out;
    }
}

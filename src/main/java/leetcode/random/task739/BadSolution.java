package leetcode.random.task739;

import java.util.Comparator;
import java.util.PriorityQueue;

class BadSolution {
    int[] dailyTemperatures(int[] temperatures) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(index -> temperatures[index]));
        int[] out = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!queue.isEmpty() && temperatures[i] > temperatures[queue.peek()]) {
                int ind = queue.poll();
                out[ind] = i - ind;
            }
            queue.add(i);
        }
        return out;
    }
}
package leetcode.random.task933;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
class RecentCounter {
    Queue<Integer> queue = new ArrayDeque<>();

    int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}

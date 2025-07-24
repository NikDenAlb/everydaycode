package leetcode.random.task2462;

import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int i = 0;
        int j = costs.length - 1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        long out = 0;
        while (k-- > 0) {
            while (pq1.size() < candidates && i <= j) {
                pq1.offer(costs[i++]);
            }
            while (pq2.size() < candidates && i <= j) {
                pq2.offer(costs[j--]);
            }

            int t1 = !pq1.isEmpty() ? pq1.peek() : Integer.MAX_VALUE;
            int t2 = !pq2.isEmpty() ? pq2.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                out += t1;
                pq1.poll();
            } else {
                out += t2;
                pq2.poll();
            }
        }
        return out;
    }
}
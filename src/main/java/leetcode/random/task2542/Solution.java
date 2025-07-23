package leetcode.random.task2542;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] score = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++)
            score[i] = new int[]{nums2[i], nums1[i]};
        Arrays.sort(score, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.comparingInt(e -> e));
        long out = 0, sumS = 0;
        for (int[] sc : score) {
            pq.add(sc[1]);
            sumS = (sumS + sc[1]);
            if (pq.size() > k) sumS -= pq.poll();
            if (pq.size() == k) out = Math.max(out, (sumS * sc[0]));
        }
        return out;
    }
}

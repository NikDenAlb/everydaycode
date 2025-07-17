package leetcode.random.task875;

import java.util.Arrays;

class Solution {
    int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        for (int r = Arrays.stream(piles).max().orElseThrow(); l < r; ) {
            int mid = l + (r - l) / 2;
            int hours = 0;
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }
            if (hours <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
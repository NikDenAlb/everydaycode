package leetcode.random.task128;

import java.util.HashSet;
import java.util.Set;

//todo implement another idea
class Solution {
    int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int out = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cnt = 1;
                while (set.contains(num + cnt)) {
                    cnt++;
                }
                out = Math.max(cnt, out);
            }
        }
        return out;
    }
}
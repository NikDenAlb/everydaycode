package leetcode.random.task169;

class Solution {
    int majorityElement(int[] nums) {
        int cnt = 1;
        int out = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == out) {
                cnt++;
            } else {
                if (--cnt == 0) {
                    out = nums[i];
                    cnt = 1;
                }
            }
        }
        return out;
    }
}
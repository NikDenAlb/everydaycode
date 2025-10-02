package leetcode.random.task153;

class Solution {
    int findMin(int[] nums) {
        int l = 0;
        for (int r = nums.length - 1; l < r; ) {
            int m = (l + r) / 2;
            if (nums[m] >= nums[0]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return Math.min(nums[l], nums[0]);
    }
}
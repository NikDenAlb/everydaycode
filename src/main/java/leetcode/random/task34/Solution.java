package leetcode.random.task34;

class Solution {
    int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else break;
        }
        if (m > nums.length - 1 || nums[m] != target) return new int[]{-1, -1};
        int oL = m;
        while (l < oL) {
            int mm = (oL + l) / 2;
            if (nums[mm] == target) {
                oL = mm;
            } else {
                l = mm + 1;
            }
        }
        while (m < r) {
            int mm = (m + r + 1) / 2;
            if (nums[mm] == target) {
                m = mm;
            } else {
                r = mm - 1;
            }
        }
        return new int[]{oL, r};
    }
}
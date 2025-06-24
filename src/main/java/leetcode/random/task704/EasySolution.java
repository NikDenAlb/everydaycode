package leetcode.random.task704;

class EasySolution {
    int search(int[] nums, int target) {
        int l = 0;
        for (int r = nums.length - 1; l <= r; ) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target) {
                r = m - 1;
            }
            if (nums[m] < target) {
                l = m + 1;
            }
        }
        return -1;
    }
}

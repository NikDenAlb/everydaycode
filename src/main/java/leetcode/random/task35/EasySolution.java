package leetcode.random.task35;

class EasySolution {
    int searchInsert(int[] nums, int target) {
        int r = nums.length;
        for (int l = 0; l < r; ) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m;
            } else {
                return m;
            }
        }
        return r;
    }
}
package leetcode.random.task162;

/**
 * Not easy. It's interesting and can't be half-done
 */
class MySolution {
    int findPeakElement(int[] nums) {
        int l = 0;
        for (int r = nums.length - 1; l < r; ) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}

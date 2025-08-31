package leetcode.random.task209;

class Solution {
    int minSubArrayLen(int target, int[] nums) {
        int sum = nums[0];
        if (sum >= target) return 1;
        int out = 0, j = 1;
        for (; j < nums.length; j++) {
            sum += nums[j];
            if (sum >= target) {
                out = j + 1;
                sum -= nums[0];
                break;
            }
        }
        if (j == nums.length) {
            return 0;
        }
        for (int i = 1; ; ) {
            while (sum >= target) {
                if (--out == 1) {
                    return 1;
                }
                sum -= nums[i++];
            }
            if (++j == nums.length) {
                break;
            }
            sum += nums[j] - nums[i++];
        }
        return out;
    }
}
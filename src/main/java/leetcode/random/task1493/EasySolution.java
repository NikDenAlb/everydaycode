package leetcode.random.task1493;

class EasySolution {
    int longestSubarray(int[] nums) {
        int zero = -1;
        int j = 0;
        for (; j < nums.length; j++) {
            if (nums[j] == 0) {
                zero = j++;
                break;
            }
        }
        if (zero == -1) {
            return nums.length - 1;
        }
        int ans = 0;
        int i = -1;
        for (; j < nums.length; j++) {
            if (nums[j] == 0) {
                ans = Math.max(ans, j - i - 2);
                i = zero;
                zero = j;
            }
        }
        if (i == -1) {
            return nums.length - 1;
        }
        if (zero != nums.length - 1) {
            ans = Math.max(ans, j - i - 2);
        }
        return ans;
    }
}

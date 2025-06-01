package leetcode.random.task724;

class EasySolution {
    int pivotIndex(int[] nums) {
        int[] rSum = new int[nums.length];
        rSum[nums.length - 1] = 0;
        for (int i = rSum.length - 2; i >= 0; i--) {
            rSum[i] = rSum[i + 1] + nums[i + 1];
        }
        if (rSum[0] == 0) {
            return 0;
        }
        int lSum = 0;
        for (int i = 1; i < nums.length; i++) {
            lSum += nums[i - 1];
            if (lSum == rSum[i]) {
                return i;
            }
        }
        return -1;
    }
}

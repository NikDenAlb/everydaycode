package leetcode.random.task643;

class EasySolution {
    double findMaxAverage(int[] nums, int k) {
        int sum = nums[0];
        for (int i = 1; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }
}

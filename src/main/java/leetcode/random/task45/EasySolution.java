package leetcode.random.task45;

class EasySolution {
    int jump(int[] nums) {
        int max = 0, i = 0, cnt = 0;
        while (max < nums.length - 1) {
            cnt++;
            for (int step = max; i <= step; i++) {
                max = Math.max(nums[i] + i, max);
            }
        }
        return cnt;
    }
}
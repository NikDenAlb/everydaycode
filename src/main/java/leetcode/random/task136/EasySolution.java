package leetcode.random.task136;

class EasySolution {
    int singleNumber(int[] nums) {
        int out = nums[0];
        for (int i = 1; i < nums.length; i++) {
            out ^= nums[i];
        }
        return out;
    }
}

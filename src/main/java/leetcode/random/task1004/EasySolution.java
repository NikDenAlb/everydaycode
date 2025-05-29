package leetcode.random.task1004;

class EasySolution {
    int longestOnes(int[] nums, int k) {
        int max = 0;
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            if (nums[j] == 0) {
                k--;
            }
            if (k < 0) {
                max = Math.max(max, j - i);
                while (k < 0) {
                    if (nums[i++] == 0) {
                        k++;
                    }
                    if (i == nums.length) {
                        return max;
                    }
                }
            }
        }
        return Math.max(max, j - i);
    }
}

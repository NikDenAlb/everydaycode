package leetcode.random.task80;

class EasySolution {
    int removeDuplicates(int[] nums) {
        int j = 1;
        boolean dup = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[j - 1]) {
                if (!dup) {
                    nums[j++] = nums[i];
                    dup = true;
                }
            } else {
                nums[j++] = nums[i];
                dup = false;
            }
        }
        return j;
    }
}

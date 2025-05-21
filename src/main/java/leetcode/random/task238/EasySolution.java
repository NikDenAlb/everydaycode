package leetcode.random.task238;

class EasySolution {
    int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];
        out[out.length - 1] = nums[nums.length - 1];
        for (int i = out.length - 2; i > 0; i--) {
            out[i] = nums[i] * out[i + 1];
        }
        int pref = nums[0];
        out[0] = out[1];
        for (int i = 1; i < out.length - 1; i++) {
            out[i] = pref * out[i + 1];
            pref *= nums[i];
        }
        out[out.length - 1] = pref;
        return out;
    }
}

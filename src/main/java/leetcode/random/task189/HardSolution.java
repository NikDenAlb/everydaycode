package leetcode.random.task189;

class HardSolution {
    void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, 0, nums.length - 1);
    }

    void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int t = arr[i];
            arr[i++] = arr[j];
            arr[j--] = t;
        }
    }
}

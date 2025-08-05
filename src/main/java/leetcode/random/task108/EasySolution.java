package leetcode.random.task108;

class EasySolution {
    TreeNode sortedArrayToBST(int[] nums) {
        return buildNode(nums, 0, nums.length - 1);
    }

    TreeNode buildNode(int[] nums, int l, int r) {
        int m = l + (r - l) / 2;
        TreeNode out = new TreeNode(nums[m]);
        if (l < m) {
            out.left = buildNode(nums, l, m - 1);
        }
        if (r > m) {
            out.right = buildNode(nums, m + 1, r);
        }
        return out;
    }
}

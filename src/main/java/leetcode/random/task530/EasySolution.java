package leetcode.random.task530;

class EasySolution {
    int min = Integer.MAX_VALUE;

    int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    void dfs(TreeNode node) {
        if (node.left != null) {
            TreeNode l = node.left;
            while (l.right != null) {
                l = l.right;
            }
            min = Math.min(node.val - l.val, min);
            dfs(node.left);
        }
        if (node.right != null) {
            TreeNode r = node.right;
            while (r.left != null) {
                r = r.left;
            }
            min = Math.min(r.val - node.val, min);
            dfs(node.right);
        }
    }
}

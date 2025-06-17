package leetcode.random.task437;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class EasySolution {
    static int count;
    static int tSum;

    int pathSum(TreeNode root, int targetSum) {
        count = 0;
        tSum = targetSum;
        start(root);
        return count;
    }

    void start(TreeNode node) {
        if (node != null) {
            dfs(node, 0);
            start(node.left);
            start(node.right);
        }
    }

    void dfs(TreeNode node, long pSum) {
        if (node == null) {
            return;
        }
        pSum += node.val;
        if (pSum == tSum) {
            count++;
        }
        dfs(node.left, pSum);
    }
}
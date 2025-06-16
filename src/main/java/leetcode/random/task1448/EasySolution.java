package leetcode.random.task1448;

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

public class EasySolution {
    static int count = 0;

    int goodNodes(TreeNode root) {
        count = 0;
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    static void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (max <= root.val) {
            count++;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}

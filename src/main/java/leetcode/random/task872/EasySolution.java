package leetcode.random.task872;

import java.util.ArrayList;
import java.util.List;

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
    boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> lvs1 = new ArrayList<>();
        List<Integer> lvs2 = new ArrayList<>();
        dfs(lvs1, root1);
        dfs(lvs2, root2);
        return lvs1.equals(lvs2);
    }

    static void dfs(List<Integer> lvs, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            lvs.add(root.val);
        } else {
            dfs(lvs, root.left);
            dfs(lvs, root.right);
        }
    }
}

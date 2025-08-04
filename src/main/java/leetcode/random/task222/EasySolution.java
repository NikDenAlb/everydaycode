package leetcode.random.task222;

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
    int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int cnt = 1;
        List<TreeNode> line = new ArrayList<>(List.of(root));
        while (true) {
            List<TreeNode> newLine = new ArrayList<>();
            for (TreeNode node : line) {
                if (node.left == null) {
                    return cnt;
                }
                newLine.add(node.left);
                cnt++;
                if (node.right == null) {
                    return cnt;
                }
                newLine.add(node.right);
                cnt++;
            }
            line = newLine;
        }
    }
}

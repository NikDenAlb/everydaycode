package leetcode.random.task199;

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
    List<Integer> out;

    List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        out = new ArrayList<>();
        out.add(root.val);
        layerCheck(List.of(root));
        return out;
    }

    void layerCheck(List<TreeNode> layer) {
        List<TreeNode> nextLayer = new ArrayList<>();
        for (TreeNode treeNode : layer) {
            if (treeNode.left != null) {
                nextLayer.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nextLayer.add(treeNode.right);
            }
        }
        if (nextLayer.isEmpty()) {
            return;
        }
        out.add(nextLayer.getLast().val);
        layerCheck(nextLayer);
    }
}

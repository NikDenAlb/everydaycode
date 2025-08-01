package leetcode.random.task101;

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
    boolean isSymmetric(TreeNode root) {
        return isMirrorTree(root.left, root.right);
    }

    boolean isMirrorTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return false;
        }
        List<TreeNode> layP = new ArrayList<>();
        List<TreeNode> layQ = new ArrayList<>();
        if (p.val != q.val) {
            return false;
        }
        layP.add(p);
        layQ.add(q);
        while (!layP.isEmpty()) {
            List<TreeNode> layPNext = new ArrayList<>();
            List<TreeNode> layQNext = new ArrayList<>();
            for (int i = 0; i < layP.size(); i++) {
                p = layP.get(i);
                q = layQ.get(i);
                if (p.left == null) {
                    if (q.right != null) {
                        return false;
                    }
                } else {
                    if (q.right == null) {
                        return false;
                    }
                    if (q.right.val != p.left.val) {
                        return false;
                    }
                    layPNext.add(p.left);
                    layQNext.add(q.right);
                }
                if (p.right == null) {
                    if (q.left != null) {
                        return false;
                    }
                } else {
                    if (q.left == null) {
                        return false;
                    }
                    if (q.left.val != p.right.val) {
                        return false;
                    }
                    layPNext.add(p.right);
                    layQNext.add(q.left);
                }
            }
            layP = layPNext;
            layQ = layQNext;
        }
        return true;
    }
}

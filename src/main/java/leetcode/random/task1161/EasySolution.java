package leetcode.random.task1161;

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

public class EasySolution {
    int mSum;
    int mLvl;

    int maxLevelSum(TreeNode root) {
        mSum = root.val;
        mLvl = 1;
        bfs(List.of(root), mLvl);
        return mLvl;
    }

    void bfs (List<TreeNode> prev, int lvl) {
        List<TreeNode> curr = new ArrayList<>();
        int sum = 0;
        for (TreeNode node : prev) {
            if (node.left != null) {
                curr.add(node.left);
                sum += node.left.val;
            }
            if (node.right != null) {
                curr.add(node.right);
                sum += node.right.val;
            }
        }
        if (curr.isEmpty()) {
            return;
        }
        lvl++;
        if (sum > mSum) {
            mSum = sum;
            mLvl = lvl;
        }
        bfs(curr, lvl);
    }
}

package leetcode.random.task94;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> out;

    List<Integer> inorderTraversal(TreeNode root) {
        out = new ArrayList<>();
        dfs(root);
        return out;
    }

    void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.left);
            out.add(node.val);
            dfs(node.right);
        }
    }
}

package leetcode.random.task1372;

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
    int out;

    int longestZigZag(TreeNode root) {
        if (root == null) {
            return -1;
        }
        out = 0;
        dfs(root.left, false, 0);
        dfs(root.right, true, 0);
        return out;
    }

    void dfs(TreeNode node, boolean right, int cnt) {
        if (node == null) {
            return;
        }
        if (++cnt > out) {
            out = cnt;
        }
        if (right) {
            dfs(node.left, false, cnt);
            dfs(node.right, true, 0);
        } else {
            dfs(node.left, false, 0);
            dfs(node.right, true, cnt);
        }
    }
}

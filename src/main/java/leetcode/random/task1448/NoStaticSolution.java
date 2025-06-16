package leetcode.random.task1448;

/**
 * Most solutions are non-static. Sometimes hard to imagine for me
 */
class NoStaticSolution {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    private int countGoodNodes(TreeNode node, int maxVal) {
        if (node == null) return 0;

        int count = node.val >= maxVal ? 1 : 0;
        maxVal = Math.max(maxVal, node.val);

        count += countGoodNodes(node.left, maxVal);
        count += countGoodNodes(node.right, maxVal);

        return count;
    }
}

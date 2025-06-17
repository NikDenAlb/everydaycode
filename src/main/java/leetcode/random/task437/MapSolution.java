package leetcode.random.task437;

import java.util.HashMap;
import java.util.Map;

/**
 * Much faster solution with only one circle
 */
class MapSolution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Base case: one way to get sum = 0
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        currSum += node.val;
        int count = prefixSumCount.getOrDefault(currSum - target, 0);

        // Update the map with current sum
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        // Recurse left and right
        count += dfs(node.left, currSum, target, prefixSumCount);
        count += dfs(node.right, currSum, target, prefixSumCount);

        // Backtrack
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return count;
    }
}

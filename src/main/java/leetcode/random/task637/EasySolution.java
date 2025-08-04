package leetcode.random.task637;

import java.util.ArrayList;
import java.util.List;

public class EasySolution {
    List<Double> averageOfLevels(TreeNode root) {
        List<Double> out = new ArrayList<>();
        List<TreeNode> line = new ArrayList<>(List.of(root));
        while (!line.isEmpty()) {
            long sum = 0;
            List<TreeNode> newLine = new ArrayList<>();
            for (TreeNode node : line) {
                if (node.left != null) {
                    newLine.add(node.left);
                }
                if (node.right != null) {
                    newLine.add(node.right);
                }
                sum += node.val;
            }
            out.add((double) sum / line.size());
            line = newLine;
        }
        return out;
    }
}

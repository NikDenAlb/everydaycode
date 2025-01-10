package leetcode.string.easy.n1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Intuition
 * <p>
 * We scan through the string to identify the start and end of each group. If the size of the group is at least 3, we add it to the answer.
 * <p>
 * Algorithm
 * <p>
 * Maintain pointers i, j with i <= j. The i pointer will represent the start of the current group, and we will increment j forward until it reaches the end of the group.
 * <p>
 * We know that we have reached the end of the group when j is at the end of the string, or S[j] != S[j+1]. At this point, we have some group [i, j]; and after, we will update i = j+1, the start of the next group.
 * <p>
 * <p>
 * Complexity Analysis
 * <p>
 * Time Complexity: O(N), where N is the length of S.
 * <p>
 * Space Complexity: O(N), the space used by the answer.
 *
 * @author Editorial
 */
public class TwoPointerSolution implements Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N - 1 || S.charAt(j) != S.charAt(j + 1)) {
                // Here, [i, j] represents a group.
                if (j - i + 1 >= 3) ans.add(Arrays.asList(i, j));
                i = j + 1;
            }
        }
        return ans;
    }
}

package leetcode.random.task338;

/**
 * Can't think thank at a time
 */
public class BetterSolution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}

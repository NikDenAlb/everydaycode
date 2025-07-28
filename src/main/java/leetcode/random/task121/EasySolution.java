package leetcode.random.task121;

/**
 * TL, but not in Testcase
 */
class EasySolution {
    int maxProfit(int[] prices) {
        int out = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                out = Math.max(out, prices[j] - prices[i]);
            }
        }
        return out;
    }
}

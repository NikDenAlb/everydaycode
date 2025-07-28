package leetcode.random.task121;

class NextEasySolution {
    int maxProfit(int[] prices) {
        int out = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                out = Math.max(out, prices[i] - min);
            }
        }
        return out;
    }
}

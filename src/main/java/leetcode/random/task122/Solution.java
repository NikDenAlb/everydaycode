package leetcode.random.task122;

class Solution {
    int maxProfit(int[] prices) {
        int out = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                out += prices[i] - prices[i - 1];
            }
        }
        return out;
    }
}

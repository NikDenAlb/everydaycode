package leetcode.random.task714;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int hold = -50000;
        int cash = 0;
        for (int price : prices) {
            hold = Math.max(hold, cash - price);
            cash = Math.max(cash, hold + price - fee);
        }
        return cash;
    }
}
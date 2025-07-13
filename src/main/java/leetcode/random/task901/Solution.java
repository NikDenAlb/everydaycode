package leetcode.random.task901;

import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    Deque<int[]> stack = new ArrayDeque<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int out = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            out += stack.pop()[1];
        }
        stack.push(new int[]{price, out});
        return out;
    }
}

/*
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

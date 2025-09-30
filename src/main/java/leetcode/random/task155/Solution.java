package leetcode.random.task155;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<Node> list;

    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        list.add(list.isEmpty() ? new Node(val, val) : new Node(val, Math.min(list.getLast().min, val)));
    }

    public void pop() {
        list.removeLast();
    }

    public int top() {
        return list.getLast().val;
    }

    public int getMin() {
        return list.getLast().min;
    }

    class Node {
        int val;
        int min;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}


/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

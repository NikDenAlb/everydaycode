package leetcode.random.task150;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String tkn : tokens) {
            switch (tkn) {
                case "+" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Integer.parseInt(tkn));
            }
        }
        return stack.pop();
    }
}
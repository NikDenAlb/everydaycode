package leetcode.random.task20;

import java.util.ArrayDeque;
import java.util.Deque;

class EasySolution {
    boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(', '{', '[' -> stack.push(c);
                case ')' -> {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                case '}' -> {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                case ']' -> {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}

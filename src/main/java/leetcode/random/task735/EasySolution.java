package leetcode.random.task735;

import java.util.ArrayDeque;
import java.util.Deque;

class EasySolution {
    int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int ast : asteroids) {
            if (stack.isEmpty() || stack.peek() < 0 || ast > 0) {
                stack.push(ast);
            } else {
                boolean add = true;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() == -ast) {
                        stack.pop();
                        add = false;
                        break;
                    } else if (stack.peek() < -ast) {
                        stack.pop();
                    } else {
                        add = false;
                        break;
                    }
                }
                if (add) {
                    stack.push(ast);
                }
            }
        }
        return stack.reversed().stream().mapToInt(i -> i).toArray();
    }
}

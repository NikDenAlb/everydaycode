package leetcode.random.task394;

import java.util.ArrayDeque;
import java.util.Deque;

class EasySolution {
    String decodeString(String s) {
        StringBuilder out = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = s.length() - 1; i >= 0; ) {
            if (s.charAt(i) == ']') {
                stack.push(out.length());
                i--;
            } else if (s.charAt(i) == '[') {
                i--;
                StringBuilder num = new StringBuilder();
                while (i >= 0 && Character.isDigit(s.charAt(i))) {
                    num.append(s.charAt(i--));
                }
                int cnt = Integer.parseInt(num.reverse().toString());
                int len = out.length() - stack.pop();
                for (int j = 1; j < cnt; j++) {
                    out.append(out, out.length() - len, out.length());
                }
            } else {
                out.append(s.charAt(i));
                i--;
            }
        }
        return out.reverse().toString();
    }
}

package leetcode.random.task71;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String part : parts) {
            if (!part.isEmpty() && !part.equals(".")) {
                if (part.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(part);
                }
            }
        }

        StringBuilder out = new StringBuilder();
        while (!stack.isEmpty()) {
            out.insert(0, "/" + stack.pop());
        }

        return out.isEmpty() ? "/" : out.toString();
    }
}

/* right Solution
import java.nio.file.Path;
import java.nio.file.Paths;

class Solution {
    String simplifyPath(String textPath) {return Paths.get(textPath).normalize().toString();}
}
*/
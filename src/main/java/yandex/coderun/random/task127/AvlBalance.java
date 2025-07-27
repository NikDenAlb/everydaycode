package yandex.coderun.random.task127;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * <a href="https://coderun.yandex.ru/problem/avl-balance">task link</a><br>
 * test - OK
 */
class AvlBalance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (arr[0] == 0) {
            writer.write("YES");
            reader.close();
            writer.close();
            return;
        }

        Node root = new Node(arr[0]);
        for (int i = 1; i < arr.length - 1; i++) {
            root.add(arr[i]);
        }
        boolean balance = isBalanced(root);

        writer.write(balance ? "YES" : "NO");

        reader.close();
        writer.close();
    }

    static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        HashMap<Node, Integer> heights = new HashMap<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null) {
                stack1.push(temp.left);
            }
            if (temp.right != null) {
                stack1.push(temp.right);
            }
        }
        while (!stack2.isEmpty()) {
            Node temp = stack2.pop();
            int leftH = (temp.left == null) ? -1 : heights.get(temp.left);
            int rightH = (temp.right == null) ? -1 : heights.get(temp.right);
            if (Math.abs(leftH - rightH) > 1) {
                return false;
            }
            int h = Math.max(leftH, rightH) + 1;
            heights.put(temp, h);
        }
        return true;
    }
}

class Node {
    int value;
    Node right;
    Node left;

    Node(int value) {
        this.value = value;
    }

    void add(int value) {
        if (value < this.value) {
            if (left == null) {
                left = new Node(value);
                return;
            }
            left.add(value);
        } else if (value > this.value) {
            if (right == null) {
                right = new Node(value);
                return;
            }
            right.add(value);
        }
    }
}

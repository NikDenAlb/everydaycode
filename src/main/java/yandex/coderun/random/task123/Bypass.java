package yandex.coderun.random.task123;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/bypass">task link</a><br>
 * test - OK
 */
public class Bypass {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Tree tree = new Tree();
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int val : input) {
            if (val == 0) break;
            tree.insert(val);
        }

        List<Integer> list = tree.getInOrder();
        writer.write(list.stream().map(String::valueOf).collect(Collectors.joining("\n")));

        reader.close();
        writer.close();
    }
}

class Tree {
    Node root;

    void insert(int val) {
        root = insert(root, val);
    }

    Node insert(Node node, int val) {
        if (node == null) return new Node(val);
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    List<Integer> getInOrder() {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    void inOrder(Node node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
}
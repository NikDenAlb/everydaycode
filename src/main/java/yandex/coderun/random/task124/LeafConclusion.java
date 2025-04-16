package yandex.coderun.random.task124;

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
 * <a href="https://coderun.yandex.ru/problem/leaf-conclusion">task link</a><br>
 * test - OK
 */
public class LeafConclusion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int[] nums = Arrays.stream(line).limit(line.length - 1).mapToInt(Integer::parseInt).toArray();

        Tree tree = new Tree();
        for (int num : nums) {
            tree.insert(num);
        }

        writer.write(tree.leaves().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining("\n")));

        reader.close();
        writer.close();
    }
}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }

        return node;
    }

    public List<Integer> leaves() {
        List<Integer> leaves = new ArrayList<>();
        collectLeaves(root, leaves);
        return leaves;
    }

    void collectLeaves(Node node, List<Integer> leaves) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            leaves.add(node.value);
        }

        collectLeaves(node.left, leaves);
        collectLeaves(node.right, leaves);
    }
}

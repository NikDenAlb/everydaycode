package yandex.coderun.random.task125;

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
 * <a href="https://coderun.yandex.ru/problem/fork-conclusion">task link</a><br>
 * test - OK
 */
public class ForkConclusion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int[] seq = Arrays.stream(line).limit(line.length - 1).mapToInt(Integer::parseInt).toArray();

        Tree tree = new Tree();

        for (int i : seq) {
            tree.insert(i);
        }

        List<Integer> nodesWithTwoChildren = tree.nodesWithTwoChildren();
        nodesWithTwoChildren.sort(Integer::compareTo);

        writer.write(nodesWithTwoChildren.stream().
                sorted(Integer::compareTo).
                map(String::valueOf).
                collect(Collectors.joining("\n")));

        reader.close();
        writer.close();
    }
}

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class Tree {
    Node root;

    void insert(int value) {
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

    List<Integer> nodesWithTwoChildren() {
        List<Integer> result = new ArrayList<>();
        collectNodesWithTwoChildren(root, result);
        return result;
    }

    private void collectNodesWithTwoChildren(Node node, List<Integer> result) {
        if (node == null) return;

        if (node.left != null && node.right != null) {
            result.add(node.value);
        }

        collectNodesWithTwoChildren(node.left, result);
        collectNodesWithTwoChildren(node.right, result);
    }
}

package yandex.algorithms7.warm.taskh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * test - OK
 */
public class BinaryTree {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder out = new StringBuilder();
        Tree tree = new Tree();
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            String[] command = line.split(" ");
            out.append(execute(tree, command)).append("\n");
        }
        if (!out.isEmpty()) {
            out.setLength(out.length() - 1);
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static String execute(Tree tree, String[] command) {
        return switch (command[0]) {
            case "ADD" -> tree.add(Integer.parseInt(command[1]));
            case "SEARCH" -> tree.search(Integer.parseInt(command[1]));
            case "PRINTTREE" -> tree.printTree();
            default -> throw new IllegalArgumentException();
        };
    }

}

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

class Tree {
    Node root;

    Tree() {
        root = null;
    }

    String add(int value) {
        if (root == null) {
            root = new Node(value);
            return "DONE";
        }
        return addFromNode(root, value);
    }

    String search(int value) {
        if (root == null) {
            return "NO";
        }
        if (root.value == value) {
            return "YES";
        }
        return searchFromNode(root, value);
    }

    String printTree() {
        if (root == null) {
            return "";
        }
        return printNode(root, 0);
    }

    String addFromNode(Node curr, int value) {
        if (value < curr.value) {
            if (curr.left == null) {
                curr.left = new Node(value);
                return "DONE";
            }
            return addFromNode(curr.left, value);
        }
        if (value > curr.value) {
            if (curr.right == null) {
                curr.right = new Node(value);
                return "DONE";
            }
            return addFromNode(curr.right, value);
        }
        return "ALREADY";
    }

    String searchFromNode(Node curr, int value) {
        if (value < curr.value) {
            if (curr.left == null) {
                return "NO";
            }
            return searchFromNode(curr.left, value);
        }
        if (value > curr.value) {
            if (curr.right == null) {
                return "NO";
            }
            return searchFromNode(curr.right, value);
        }
        return "YES";
    }

    String printNode(Node curr, int depth) {
        String dots = ".".repeat(depth);
        if (curr.left != null) {
            if (curr.right != null) {
                return printNode(curr.left, depth + 1) + '\n' + dots + curr.value + '\n' + printNode(curr.right, depth + 1);
            }
            return printNode(curr.left, depth + 1) + '\n' + dots + curr.value;
        }
        if (curr.right != null) {
            return dots + curr.value + '\n' + printNode(curr.right, depth + 1);
        }
        return dots + curr.value;
    }
}

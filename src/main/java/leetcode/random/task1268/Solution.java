package leetcode.random.task1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for (String product : products) {
            insert(product);
        }

        List<List<String>> out = new ArrayList<>();
        Node node = root;
        for (char c : searchWord.toCharArray()) {
            if (node != null) {
                node = node.children[c - 'a'];
            }
            if (node != null) {
                out.add(node.suggestions);
            } else {
                out.add(new ArrayList<>());
            }
        }

        return out;
    }

    class Node {
        Node[] children = new Node[26];
        List<String> suggestions = new ArrayList<>();
    }

    Node root = new Node();

    void insert(String product) {
        Node node = root;
        for (char ch : product.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Node();
            }
            node = node.children[idx];

            if (node.suggestions.size() < 3) {
                node.suggestions.add(product);
            }
        }
    }
}
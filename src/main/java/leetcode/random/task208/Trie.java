package leetcode.random.task208;

import java.util.Arrays;

class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(char ch:word.toCharArray()) {
            int idx = ch-'a';
            if(node.children[idx]==null) {
                node.children[idx] = new Node();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = root;
        for(char ch:word.toCharArray()) {
            int idx = ch-'a';
            if(node.children[idx]==null) {
                return false;
            }
            node = node.children[idx];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(char ch:prefix.toCharArray()) {
            int idx = ch-'a';
            if(node.children[idx]==null) {
                return false;
            }
            node = node.children[idx];
        }
        return true;
    }


    class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;

        Node() {
            Arrays.fill(children, null);
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
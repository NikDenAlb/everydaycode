package yandex.coderun.hrtechinterview.task10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/selections/hr-tech-interview/problems/tree-height">task link</a><br>
 * test - OK
 */
public class TreeHeight {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numsRaw = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums = Arrays.copyOf(numsRaw, numsRaw.length - 1);

        writer.write(String.valueOf(calcTreeHeight(nums)));

        reader.close();
        writer.close();
    }

    static int calcTreeHeight(int[] nums) {
        Node start = new Node(nums[0]);
        int height = 1;

        for (int i = 1; i < nums.length; i++) {
            if (addNote(start, nums[i]) > height) {
                height++;
            }
        }
        return height;
    }

    static int addNote(Node root, int e) {
        if (root.value == e) {
            return 0;
        }
        if (e > root.value) {
            if (root.nodeR == null) {
                root.nodeR = new Node(e);
                return 2;
            }
            return 1 + addNote(root.nodeR, e);
        }
        if (root.nodeL == null) {
            root.nodeL = new Node(e);
            return 2;
        }
        return 1 + addNote(root.nodeL, e);
    }
}

class Node {
    final int value;
    Node nodeR;
    Node nodeL;

    public Node(int value) {
        this.value = value;
    }
}

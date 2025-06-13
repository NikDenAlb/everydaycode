package leetcode.random.task2130;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class EasySolution {
    int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int out = Integer.MIN_VALUE;
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            out = Math.max(out, list.get(i) + list.get(j));
        }
        return out;
    }
}

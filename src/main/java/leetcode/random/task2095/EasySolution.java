package leetcode.random.task2095;

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
    ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode last = head;
        List<ListNode> arr = new ArrayList<>(List.of(head));
        do {
            last = last.next;
            arr.add(last);
        } while (last.next != null);
        if (arr.size() == 2) {
            head.next = null;
            return head;
        }
        arr.get(arr.size() / 2 - 1).next = arr.get(arr.size() / 2 + 1);
        return head;
    }
}

package leetcode.random.task2;


class Solution {
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = l1;
        int one = 0;
        ListNode tail = null;
        while (l1 != null && l2 != null) {
            tail = l1;
            l1.val = l1.val + l2.val + one;
            one = (l1.val) / 10;
            l1.val %= 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            tail.next = l2;
            l1 = l2;
        }
        while (l1 != null) {
            tail = l1;
            l1.val = l1.val + one;
            one = (l1.val) / 10;
            l1.val %= 10;
            l1 = l1.next;
        }
        if (one != 0) {
            tail.next = new ListNode(one);
        }
        return out;
    }
}

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
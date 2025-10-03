package leetcode.random.task19;


class Solution {
    ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        if (end == null) {
            return head.next;
        }
        end = end.next;
        ListNode preDel = head;
        while (end != null) {
            preDel = preDel.next;
            end = end.next;
        }
        preDel.next = preDel.next.next;
        return head;
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
}
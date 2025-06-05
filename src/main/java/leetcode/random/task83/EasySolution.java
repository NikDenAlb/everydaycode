package leetcode.random.task83;

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
    ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        if (head.next == null || head.next.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode next = curr.next;
        while (true) {
            while (next.next != null && next.val == next.next.val) {
                next = next.next;
            }
            if (next.next == null || next.next.next == null) {
                curr.next = next;
                return head;
            }
            if (curr.next != next) {
                curr.next = next;
            }
            curr = next;
            next = next.next;
        }
    }
}

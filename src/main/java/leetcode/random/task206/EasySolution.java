package leetcode.random.task206;

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
    ListNode reverseList(ListNode head) {
        // [1]
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head2 = head.next;
        head.next = null;
        // [1] [2]
        if (head2.next == null) {
            head2.next = head;
            return head2;
        }
        ListNode head3 = head2.next;
        head2.next = head;
        // [1] [2] [3]
        if (head3.next == null) {
            head3.next = head2;
            return head3;
        }
        while (true) {
            head = head3.next;
            head3.next = head2;
            // [2] [3] [1]
            if (head.next == null) {
                head.next = head3;
                return head;
            }
            head2 = head.next;
            head.next = head3;
            // [3] [1] [2]
            if (head2.next == null) {
                head2.next = head;
                return head2;
            }
            head3 = head2.next;
            head2.next = head;
            // [1] [2] [3]
            if (head3.next == null) {
                head3.next = head2;
                return head3;
            }
        }
    }
}

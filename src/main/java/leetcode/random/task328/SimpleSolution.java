package leetcode.random.task328;

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

class SimpleSolution {
    ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h2 = head.next;
        // [h] [h2]
        if (h2.next == null) {
            return head;
        }
        ListNode a = h2.next;
        // [h] [h2] [a]
        head.next = a;
        if (a.next == null) {
            a.next = h2;
            h2.next = null;
            return head;
        }
        ListNode b = a.next;
        // [h] [h2] [a] [b]
        h2.next = b;
        if (b.next == null) {
            a.next = h2;
            return head;
        }
        ListNode c = b.next;
        // [h] [h2] [a] [b] [c]
        a.next = c;
        if (c.next == null) {
            c.next = h2;
            b.next = null;
            return head;
        }
        while (true) {
            // [h] [h2] [a] [b] [c]
            // [o] [e ] [o] [e] [o]
            a = c.next;
            // [h] [h2] [b] [c] [a]
            // [o] [e ] [e] [o] [e]
            b.next = a;
            if (a.next == null) {
                c.next = h2;
                return head;
            }
            b = a.next;
            // [h] [h2] [c] [a] [b]
            // [o] [e ] [o] [e] [o]
            c.next = b;
            if (b.next == null) {
                b.next = h2;
                a.next = null;
                return head;
            }
            c = b.next;
            // [h] [h2] [a] [b] [c]
            // [o] [e ] [e] [o] [e]
            a.next = c;
            if (c.next == null) {
                b.next = h2;
                return head;
            }
            a = c.next;
            // [h] [h2] [b] [c] [a]
            // [o] [e ] [o] [e] [o]
            b.next = a;
            if (a.next == null) {
                a.next = h2;
                c.next = null;
                return head;
            }
            b = a.next;
            // [h] [h2] [c] [a] [b]
            // [o] [e ] [e] [o] [e]
            c.next = b;
            if (b.next == null) {
                a.next = h2;
                return head;
            }
            c = b.next;
            // [h] [h2] [a] [b] [c]
            // [o] [e ] [o] [e] [o]
            a.next = c;
            if (c.next == null) {
                c.next = h2;
                b.next = null;
                return head;
            }
        }
    }
}

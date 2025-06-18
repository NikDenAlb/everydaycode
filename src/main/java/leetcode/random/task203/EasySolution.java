package leetcode.random.task203;

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
    ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return null;
            }
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == val) {
                ListNode prev = curr;
                curr = curr.next;
                while (curr != null) {
                    if (curr.val != val) {
                        break;
                    }
                    curr = curr.next;
                }
                prev.next = curr;
                if (curr == null || curr.next == null) {
                    return head;
                }
                if (curr.next.val == val) {
                    continue;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}

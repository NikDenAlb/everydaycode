package leetcode.random.task92;

class Solution {
    ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode prev = head;
        for (int i = 2; i < left; i++) {
            prev = prev.next;
        }
        ListNode first = left == 1 ? head : prev.next;
        ListNode curr = first.next;
        ListNode preC = first;
        for (int i = left; i < right; i++) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = preC;
            preC = temp;
        }
        prev.next = left == 1 ? null : preC;
        first.next = curr;
        return left == 1 ? preC : head;
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

package leetcode.random.task206;

/**
 * DHort solution with temp Node
 */
class ShortLookSolution {
    ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = null;
        head = prev;
        return head;
    }
}

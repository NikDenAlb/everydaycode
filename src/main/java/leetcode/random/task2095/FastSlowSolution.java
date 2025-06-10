package leetcode.random.task2095;

/**
 * Should be easy solution, but mine was experimental. And no need of prev, slow should be mid-1
 */
class FastSlowSolution {
    ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}

package leetcode.random.task203;

/**
 * Nice to see and fast solution.
 */
class RecursiveSolution {
    ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head;
    }
}

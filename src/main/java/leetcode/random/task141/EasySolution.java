package leetcode.random.task141;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class EasySolution {
    boolean hasCycle(ListNode head) {
        for (int i = 0; i < 10_001; i++) {
            if (head == null) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}

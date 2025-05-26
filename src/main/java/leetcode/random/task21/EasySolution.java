package leetcode.random.task21;

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
    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        boolean position = list2.val < list1.val;
        ListNode start = position ? list2 : list1;

        /*
        list2                   true
        -----------------------------
        list1                   false
         */
        while (true) {
            if (!position) {
                if (list1.next == null) {
                    list1.next = list2;
                    break;
                }
                if (list1.next.val <= list2.val) {
                    list1 = list1.next;
                } else {
                    ListNode temp = list1.next;
                    list1.next = list2;
                    list1 = temp;
                    position = true;
                }
            } else {
                if (list2.next == null) {
                    list2.next = list1;
                    break;
                }
                if (list2.next.val <= list1.val) {
                    list2 = list2.next;
                } else {
                    ListNode temp = list2.next;
                    list2.next = list1;
                    list2 = temp;
                    position = false;
                }
            }
        }
        return start;
    }
}

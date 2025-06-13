package leetcode.random.task2130;

/**
 * Faster solution. Go to the end 1st
 */
class CalcSizeSolution {
    int pairSum(ListNode head) {
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        int i = 0;
        temp = head;
        int arr[] = new int[n / 2];
        while (i < (n / 2)) {
            arr[i++] = temp.val;
            temp = temp.next;
        }
        i = n / 2 - 1;
        while (temp != null) {
            arr[i--] += temp.val;
            temp = temp.next;
        }
        int max = 0;
        for (i = 0; i < n / 2; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}

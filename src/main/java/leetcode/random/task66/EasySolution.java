package leetcode.random.task66;

class EasySolution {
    int[] plusOne(int[] digits) {
        int[] ans = new int[digits.length];
        boolean add = true;
        int i = digits.length - 1;
        while (add && i >= 0) {
            if (digits[i] == 9) {
                ans[i] = 0;
                i--;
            } else {
                ans[i] = digits[i] + 1;
                add = false;
            }
        }
        if (add) {
            int[] out = new int[digits.length + 1];
            out[0] = 1;
            System.arraycopy(ans, 0, out, 1, digits.length);
            return out;
        } else {
            System.arraycopy(digits, 0, ans, 0, i);
            return ans;
        }
    }
}

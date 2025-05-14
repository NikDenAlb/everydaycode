package leetcode.random.task9;

class FastSolution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int or = x;
        int n = 0;

        while (x > 0) {
            int te = x % 10;
            n = n * 10 + te;
            x = x / 10;
        }
        return n == or;
    }
}

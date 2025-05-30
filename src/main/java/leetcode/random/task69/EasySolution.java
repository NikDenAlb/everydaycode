package leetcode.random.task69;

class EasySolution {
    int mySqrt(int x) {
        int l = 0;
        for (int r = x; l < r; ) {
            long m = ((long) l + r + 1) / 2;
            if (m * m > x) {
                r = (int) (m - 1);
            } else if (m * m < x) {
                l = (int) m;
            } else {
                return (int) m;
            }
        }
        return l;
    }
}

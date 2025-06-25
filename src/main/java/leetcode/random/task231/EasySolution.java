package leetcode.random.task231;

public class EasySolution {
    boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            if (n == 1 << i) {
                return true;
            }
        }
        return false;
    }
}

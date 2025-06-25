package leetcode.random.task231;

/**
 * Definitely the best
 */
class FastSolution {
    boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0 && n > 0;
    }
}

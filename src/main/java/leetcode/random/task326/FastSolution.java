package leetcode.random.task326;

class FastSolution {
    public boolean isPowerOfThree(int n) {
        int maxPowerOf3 = 1162261467; // 3^19, the highest power of 3 within 32-bit signed int
        return n > 0 && (maxPowerOf3 % n == 0);
    }
}

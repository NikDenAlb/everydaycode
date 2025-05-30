package leetcode.random.task1732;

class EasySolution {
    int largestAltitude(int[] gain) {
        int out = 0, sum = 0;
        for (int g : gain) {
            sum += g;
            out = Math.max(out, sum);
        }
        return out;
    }
}

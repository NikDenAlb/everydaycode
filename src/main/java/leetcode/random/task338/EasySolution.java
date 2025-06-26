package leetcode.random.task338;

class EasySolution {
    int[] countBits(int n) {
        int[] out = new int[n + 1];
        out[0] = 0;
        if (n == 0) {
            return out;
        }
        out[1] = 1;
        for (int i = 2, rpt = 2; i < out.length; ) {
            for (int j = rpt; j > 0 && i < out.length; j--, i++) {
                out[i] = out[i - j] + 1;
            }
            rpt <<= 1;
        }
        return out;
    }
}

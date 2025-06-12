package leetcode.random.task190;

class EasySolution {
    // you need treat n as an unsigned value
    int reverseBits(int n) {
        int out = 0;
        for (int i = 0; i < 31; i++) {
            out += n & 1;
            n >>= 1;
            out <<= 1;
        }
        out += n & 1;
        return out;
    }
}

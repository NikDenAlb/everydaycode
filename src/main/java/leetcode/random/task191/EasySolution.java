package leetcode.random.task191;

class EasySolution {
    int hammingWeight(int n) {
        int cnt = n & 1;
        n >>= 1;
        while (n > 0) {
            cnt += n & 1;
            n >>= 1;
        }
        return cnt;
    }
}

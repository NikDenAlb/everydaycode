package leetcode.random.task1318;

class EasySolution {
    int minFlips(int a, int b, int c) {
        int or = a | b;
        int cnt = 0;
        for (int i = 0; i < 30; i++) {
            int bit = 1 << i;
            if ((c & bit) != (or & bit)) {
                if ((c & bit) != bit && (a & bit) == bit && (b & bit) == bit) {
                    cnt += 2;
                } else {
                    cnt++;
                }
            }

        }
        return cnt;
    }
}
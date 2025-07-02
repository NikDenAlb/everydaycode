package leetcode.random.task790;

class HardSolution {
    int MOD = 1_000_000_007;

    int numTilings(int n) {
        long[] dp = new long[n];
        if (n < 4) {
            if (n < 3) {
                return n;
            }
            return 5;
        }
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;
        for (int i = 3; i < n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }
        return (int) dp[n - 1];
    }
}

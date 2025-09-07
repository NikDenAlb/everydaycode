package yandex.coderun.random.task162;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * <a href="https://coderun.yandex.ru/problem/random-swaps">task link</a><br>
 * test - OK
 */
public class RandomSwaps {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        long n = Long.parseLong(s);
        int k = Integer.parseInt(reader.readLine());

        int gCnt = 0;
        if (n % 3 == 0) {
            for (char c : s.toCharArray()) {
                int d = c - '0';
                if (d == 5 || d % 2 == 0) {
                    gCnt++;
                }
            }
        } else {
            for (char c : s.toCharArray()) {
                int d = c - '0';
                if (d == 5) {
                    gCnt++;
                }
            }
        }

        BigInteger[][] dp = new BigInteger[k + 1][2];
        dp[0][0] = (n % 5 == 0 || n % 6 == 0) ? BigInteger.ONE : BigInteger.ZERO;
        dp[0][1] = BigInteger.ONE;
        int nn = s.length() * (s.length() - 1);
        for (int i = 1; i <= k; i++) {
            dp[i][0] = dp[i - 1][0].multiply(BigInteger.valueOf(nn - 2L * s.length())).add(BigInteger.valueOf(2L * gCnt).multiply(dp[i - 1][1]));
            dp[i][1] = dp[i - 1][1].multiply(BigInteger.valueOf(nn));
            BigInteger gcd = dp[i][0].gcd(dp[i][1]);
            dp[i][0] = dp[i][0].divide(gcd);
            dp[i][1] = dp[i][1].divide(gcd);
        }

        writer.write(String.format("%.15f", dp[k][0].doubleValue() / dp[k][1].doubleValue()));

        reader.close();
        writer.close();
    }
}

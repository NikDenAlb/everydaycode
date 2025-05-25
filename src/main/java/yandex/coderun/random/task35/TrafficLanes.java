package yandex.coderun.random.task35;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/traffic-lanes">task link</a><br>
 * test - OK
 */
public class TrafficLanes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] mn = reader.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        long[][] dp = new long[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m) {
                    dp[i + 1][j] += dp[i][j];
                    if (j + 1 < n) {
                        dp[i + 1][j + 1] += dp[i][j];
                    }
                }
                if (j + 1 < n) {
                    dp[i][j + 1] += dp[i][j];
                }
            }
        }

        writer.write(String.valueOf(dp[m - 1][n - 1]));

        reader.close();
        writer.close();
    }
}

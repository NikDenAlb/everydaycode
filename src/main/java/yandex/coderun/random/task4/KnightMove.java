package yandex.coderun.random.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/knight-move">task link</a><br>
 * test - OK
 */
public class KnightMove {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] dp = new int[n + 2][m + 2];
        dp[0][0] = 1;
        dp[1][2] = 1;
        dp[2][1] = 1;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                dp[i + 2][j + 1] += dp[i][j];
                dp[i + 1][j + 2] += dp[i][j];
            }
        }

        writer.write(String.valueOf(dp[n - 1][m - 1]));

        reader.close();
        writer.close();
    }
}

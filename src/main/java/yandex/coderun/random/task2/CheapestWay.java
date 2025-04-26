package yandex.coderun.random.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/cheapest-way">task link</a><br>
 * test - OK
 */
public class CheapestWay {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] field = new int[n][/*m*/];

        for (int i = 0; i < n; i++) {
            field[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[n][m];
        dp[0][0] = field[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] += dp[i - 1][0] + field[i][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] += dp[0][i - 1] + field[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] += field[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        writer.write(String.valueOf(dp[n - 1][m - 1]));

        reader.close();
        writer.close();
    }
}

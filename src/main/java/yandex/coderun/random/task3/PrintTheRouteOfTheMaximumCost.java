package yandex.coderun.random.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/print-the-route-of-the-maximum-cost">task link</a><br>
 * test - OK
 */
public class PrintTheRouteOfTheMaximumCost {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] field = new int[n][m];
        for (int i = 0; i < n; i++) {
            field[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[n][m];
        StringBuilder[][] dpDir = new StringBuilder[n][m];

        /*
        +   -   -
        -   -   -
        -   -   -
         */
        dp[0][0] = field[0][0];
        dpDir[0][0] = new StringBuilder();

        /*
        *   +   +
        +   -   -
        +   -   -
         */
        for (int i = 1; i < n; i++) {
            dp[i][0] = field[i][0] + dp[i - 1][0];
            dpDir[i][0] = new StringBuilder();
            dpDir[i][0].append(dpDir[i - 1][0]).append('D').append(" ");
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = field[0][i] + dp[0][i - 1];
            dpDir[0][i] = new StringBuilder();
            dpDir[0][i].append(dpDir[0][i - 1]).append('R').append(" ");
        }

        /*
         *   *   *
         *   +   +
         *   +   +
         */
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dpDir[i][j] = new StringBuilder();
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + field[i][j];
                    dpDir[i][j].append(dpDir[i - 1][j]).append('D').append(" ");
                } else {
                    dp[i][j] = dp[i][j - 1] + field[i][j];
                    dpDir[i][j].append(dpDir[i][j - 1]).append('R').append(" ");
                }
            }
        }

        if (n > 1 || m > 1) {
            dpDir[n - 1][m - 1].setLength(dpDir[n - 1][m - 1].length() - 1);
        }
        writer.write(dp[n - 1][m - 1] + "\n" + dpDir[n - 1][m - 1].toString());

        reader.close();
        writer.close();
    }
}

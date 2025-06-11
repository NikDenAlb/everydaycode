package yandex.coderun.random.task151;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/grasshopper">task link</a><br>
 * test - OK
 */
public class Grasshopper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i <= k && i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        for (int i = k + 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i] += dp[i - j];
            }
        }

        writer.write(String.valueOf(dp[n - 1]));

        reader.close();
        writer.close();
    }
}

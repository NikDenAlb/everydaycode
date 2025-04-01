package yandex.algorithms7.warm.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/three-blocks-row">task link</a><br>
 * test - OK
 */
public class ThreeBlocksRow {
    static int maxN = 35;
    static int[] dp = new int[maxN];

    public static void main(String[] args) throws IOException {
        dp[0] = 2;
        dp[1] = 4;
        dp[2] = 7;
        for (int i = 3; i < maxN; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(Integer.toString(dp[Integer.parseInt(reader.readLine()) - 1]));

        reader.close();
        writer.close();
    }
}

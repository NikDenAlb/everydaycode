package yandex.coderun.random.task361;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/pin">task link</a><br>
 * test - OK
 */
public class Pin {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();
        int[] pins = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(pins);

        int[] dp = new int[pins.length - 1];

        /*
        |-|
         */
        dp[0] = pins[1] - pins[0];

        /*
        |-|-|
         */
        if (pins.length > 2) {
            dp[1] = pins[2] - pins[0];
        }

        /*
        |-| |-|
         */
        if (pins.length > 3) {
            dp[2] = dp[0] + pins[3] - pins[2];
        }

        /*
        |-|-|
        |-| |-|
        |-|?|?|-|
        */
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + pins[i + 1] - pins[i];
        }

        writer.write(String.valueOf(dp[dp.length - 1]));

        reader.close();
        writer.close();
    }
}

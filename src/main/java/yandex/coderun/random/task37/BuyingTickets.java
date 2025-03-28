package yandex.coderun.random.task37;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


/*
[] [] [] [] [] [] [] [] [] []
----    .....]+[]+[....
----    ...]+[][]+[....
----    .....]+[][]+[....

[][][]
[]+[][]

[][]+[]

[]+[]+[]
 */

/**
 * <a href="https://coderun.yandex.ru/problem/buying-tickets">task link</a><br>
 * test - OK
 */
public class BuyingTickets {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[][] queue = new int[n][];
        for (int i = 0; i < queue.length; i++) {
            queue[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] dp = new int[n];

        dp[0] = queue[0][0];

        if (n > 1) {
            dp[1] = Math.min(queue[0][0] + queue[1][0], queue[0][1]);
        }

        if (n > 2) {
            dp[2] = Math.min(Math.min(Math.min(
                   queue[0][2],
                   queue[0][0] + queue[1][1]),
                   queue[0][1] + queue[2][0]),
                   queue[0][0] + queue[1][0] + queue[2][0]);
        }
        /*

        ......[*]+[]
        ....[*]+[][]
        ...[*]+[]+[]
        ..[*]+[][][]
        .[*]+[][]+[]
        .[*]+[]+[][]
        [*]+[]+[]+[]

         */
        for (int i = 3; i < n; i++) {
            dp[i] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(
                   dp[i - 1] + queue[i][0],
                   dp[i - 2] + queue[i - 1][1]),
                   dp[i - 2] + queue[i - 1][0] + queue[i][0]),
                   dp[i - 3] + queue[i - 2][2]),
                   dp[i - 3] + queue[i - 2][1] + queue[i][0]),
                   dp[i - 3] + queue[i - 2][0] + queue[i - 1][1]),
                   dp[i - 3] + queue[i - 2][0] + queue[i - 1][0] + queue[i][0]);
        }

        writer.write(String.valueOf(dp[n - 1]));

        reader.close();
        writer.close();
    }
}

package yandex.coderun.random.task106;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/wires">task link</a><br>
 * test - OK
 */
public class Wires {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] l = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(reader.readLine());
        }

        int ans = Integer.MAX_VALUE - 1;
        for (int left = 1; left < ans; ) {
            int mid = (left + ans) / 2;
            int sum = 0;
            for (int i : l) {
                sum += i / mid;
            }
            if (sum < k) {
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        writer.write(String.valueOf(--ans));

        reader.close();
        writer.close();
    }
}

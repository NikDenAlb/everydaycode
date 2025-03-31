package yandex.coderun.random.task105;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/square">task link</a><br>
 * test - OK
 */
public class Square {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        long t = Long.parseLong(reader.readLine());

        int out = Math.min(n, m) / 2 + 1;
        for (int l = 0; l < out; ) {
            int mid = (l + out) / 2;
            if ((long) n * m - (long) (n - mid * 2) * (m - mid * 2) <= t) {
                l = mid + 1;
            } else {
                out = mid;
            }
        }

        writer.write(String.valueOf(--out));

        reader.close();
        writer.close();
    }
}

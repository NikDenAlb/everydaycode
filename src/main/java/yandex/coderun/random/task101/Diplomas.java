package yandex.coderun.random.task101;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/diplomas">task link</a><br>
 * test - OK
 */
public class Diplomas {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int w = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);

        long r = (long) Math.max(w, h) * n;
        for (long l = 0; l < r; ) {
            long m = (l + r) / 2;
            long cnt = (m / w) * (m / h);
            if (cnt < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        writer.write(String.valueOf(r));

        reader.close();
        writer.close();
    }
}

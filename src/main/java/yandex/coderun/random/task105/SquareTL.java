package yandex.coderun.random.task105;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/square">task link</a><br>
 * test - TL
 */
public class SquareTL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        long t = Long.parseLong(reader.readLine());

        int out = 0;
        while (t >= 2L * (m + n) - 4) {
            t -= 2L * (m + n) - 4;
            n -= 2;
            m -= 2;
            out++;
        }

        writer.write(String.valueOf(out));

        reader.close();
        writer.close();
    }
}

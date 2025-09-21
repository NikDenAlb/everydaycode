package yandex.coderun.random.task445;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/tiles">task link</a><br>
 * test - OK
 */
public class Tiles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int B = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        int hP = (B + 4) / 2;

        for (int l = 3, r = hP / 2; l <= r; ) {
            int m = (l + r) / 2;
            int w = (m - 2) * (hP - m - 2);
            if (w < W) {
                l = m + 1;
            } else if (w > W) {
                r = m - 1;
            } else {
                writer.write(hP - m + " " + m);
                reader.close();
                writer.close();
                return;
            }
        }

        throw new RuntimeException();
    }
}

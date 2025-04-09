package yandex.coderun.random.task137;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/minimum-rectangle">task link</a><br>
 * test - OK
 */
public class MinimumRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(reader.readLine());
        int[] x = new int[k], y = new int[k];
        for (int i = 0; i < k; i++) {
            String[] inp = reader.readLine().split(" ");
            x[i] = Integer.parseInt(inp[0]);
            y[i] = Integer.parseInt(inp[1]);
        }

        int minX = Arrays.stream(x).min().orElseThrow();
        int minY = Arrays.stream(y).min().orElseThrow();
        int maxX = Arrays.stream(x).max().orElseThrow();
        int maxY = Arrays.stream(y).max().orElseThrow();

        writer.write(minX + " " + minY + " " + maxX + " " + maxY);

        reader.close();
        writer.close();
    }
}

package yandex.coderun.random.task76;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/details">task link</a><br>
 * test - OK
 */
public class Details {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);

        writer.write(String.valueOf(defineDetails(n, k, m)));

        reader.close();
        writer.close();
    }

    static int defineDetails(int n, int k, int m) {
        if (k > n || m > k) {
            return 0;
        }

        int out = (n / k) * (k / m);

        n = n - m * out;

        while (n >= k) {
            int newOut = (n / k) * (k / m);
            out += newOut;
            n = n - m * newOut;
        }

        return out;
    }
}

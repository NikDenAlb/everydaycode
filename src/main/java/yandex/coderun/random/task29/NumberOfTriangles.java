package yandex.coderun.random.task29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/number-of-triangles">task link</a><br>
 * test - OK
 */
public class NumberOfTriangles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(reader.readLine());

        long out = n % 2 == 0 ? n * (n / 2 + 1) * (2 * n + 1) / 4 :
                ((n - 1) / 2 + 1) * (((n - 1) / 2) * ((n - 1) / 2) * 4 + 7 * (n - 1) / 2 + 2) / 2;

        writer.write(Long.toString(out));

        reader.close();
        writer.close();
    }
}

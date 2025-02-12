package yandex.coderun.random.task81;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/triangle">task link</a><br>
 * test - OK
 */
public class Triangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        writer.write(isTriangle(a, b, c));

        reader.close();
        writer.close();
    }

    public static String isTriangle(int a, int b, int c) {
        if (    a < b + c &&
                b < a + c &&
                c < a + b) {
            return "YES";
        }
        return "NO";
    }
}

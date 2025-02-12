package yandex.coderun.random.task79;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/equation-root">task link</a><br>
 * test - OK
 */
public class EquationRoot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        writer.write(rootEquation(a, b, c));

        reader.close();
        writer.close();
    }

    static String rootEquation(int a, int b, int c) {
        if (c < 0) {
            return "NO SOLUTION";
        }
        if (a == 0) {
            if (b == c * c) {
                return "MANY SOLUTIONS";
            } else return "NO SOLUTION";
        }

        int temp = c * c - b;

        if (temp % a != 0) {
            return "NO SOLUTION";
        }

        return String.valueOf(temp / a);
    }
}

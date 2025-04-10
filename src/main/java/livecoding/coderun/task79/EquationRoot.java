package livecoding.coderun.task79;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/equation-root">task link</a><br>
 * <a href="https://youtu.be/WAkGXEbPDxo">video link</a>
 */
public class EquationRoot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        writer.write(solveEquation(a, b, c));

        reader.close();
        writer.close();
    }

    static String solveEquation(int a, int b, int c) {
        if (c < 0) {
            return "NO SOLUTION";
        }
        if (a == 0) {
            if (b == c * c) {
                return "MANY SOLUTIONS";
            }
            return "NO SOLUTION";
        }
        int t = c * c - b;
        if (t % a != 0) {
            return "NO SOLUTION";
        }
        return String.valueOf(t / a);
    }
}

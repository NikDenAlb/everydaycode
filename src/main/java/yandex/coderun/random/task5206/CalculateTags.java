package yandex.coderun.random.task5206;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/calculate-tags">task link</a><br>
 * test - OK
 */
public class CalculateTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        writer.write(String.valueOf(calculateOut(n)));

        reader.close();
        writer.close();
    }

    static int calculateOut(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int t1 = 1, t2 = 1;
        int out = 2;
        for (int i = 2; i < n; i++) {
            int t3 = t1 + t2;
            out += t3;
            t1 = t2;
            t2 = t3;
        }
        return out;
    }
}

/*
index   0   1   2   3   4   5   6   7
value   1   1   2   3   5   8   13  21
        -   -   -   -   -   -   -   -
t       t1  t2  t3
out     1   2   4
t           t1  t2  t3
out     1   2   4   7
*/

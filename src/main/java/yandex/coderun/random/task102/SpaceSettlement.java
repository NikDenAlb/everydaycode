package yandex.coderun.random.task102;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/space-settlement">task link</a><br>
 * test - OK
 */
public class SpaceSettlement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");

        long n = Long.parseLong(input[0]); //number of modules
        long a = Long.parseLong(input[1]); //module side 1(2)
        long b = Long.parseLong(input[2]); //module side 2(2)
        long w = Long.parseLong(input[3]); //field side 1(2)
        long h = Long.parseLong(input[4]); //field side 2(2)

        //long d = Math.max(Math.min(w, h) / 2, 1);  - works slower than MAX_VALUE
        long d = Long.MAX_VALUE;

        for (long l = 0; l < d; ) {
            long m = (l + d) / 2;
            if (    (w / (a + 2 * m)) * (h / (b + 2 * m)) >= n ||
                    (h / (a + 2 * m)) * (w / (b + 2 * m)) >= n) {
                l = m + 1;
            } else {
                d = m;
            }
        }

        writer.write(String.valueOf(--d));

        reader.close();
        writer.close();
    }
}

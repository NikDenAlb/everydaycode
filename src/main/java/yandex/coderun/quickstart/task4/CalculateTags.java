package yandex.coderun.quickstart.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/calculate-tags">task link</a><br>
 * test - OK
 */
public class CalculateTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int i = Integer.parseInt(reader.readLine());
        if (i == 1) {
            writer.write("1");
        } else if (i == 2) {
            writer.write("2");
        } else {
            int out = 2;
            for (int i1 = 1, i2 = 1, i3, j = 3; j <= i; j++) {
                i3 = i1 + i2;
                i1 = i2;
                i2 = i3;
                out += i3;
            }
            writer.write(String.valueOf(out));
        }

        reader.close();
        writer.close();
    }
}

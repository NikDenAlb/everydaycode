package yandex.coderun.quickstart.task19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/castle-if">task link</a><br>
 * test - OK
 */
public class CastleIf {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        if (d >= a && e >= b ||
                d >= b && e >= a ||

                d >= a && e >= c ||
                d >= c && e >= a ||

                d >= b && e >= c ||
                d >= c && e >= b) {
            writer.write("YES");
        } else
            writer.write("NO");

        reader.close();
        writer.close();
    }
}

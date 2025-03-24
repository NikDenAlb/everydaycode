package livecoding.coderun.task74;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/castle-if">task link</a><br>
 * <a href="https://youtu.be/4bnJkENWVfk">video link</a>
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

        int temp = Math.max(a, b);
        a = Math.min(a, b);
        b = Math.min(c, temp);

        if (a <= d && b <= e || b <= d && a <= e) {
            writer.write("YES");
        } else {
            writer.write("NO");
        }

        reader.close();
        writer.close();
    }
}

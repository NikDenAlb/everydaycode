package livecoding.coderun.task76;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/castle-if">task link</a><br>
 * <a href="NEEDTOADD">video link</a>
 */
public class Details {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nkm = reader.readLine().split(" ");
        int n = Integer.parseInt(nkm[0]);
        int k = Integer.parseInt(nkm[1]);
        int m = Integer.parseInt(nkm[2]);

        int out = 0;

        for (int curr; true; ) {
            curr = n / k * (k / m);
            if (curr == 0) {
                break;
            }
            n -= curr * m;
            out += curr;
        }

        writer.write(String.valueOf(out));

        reader.close();
        writer.close();
    }
}

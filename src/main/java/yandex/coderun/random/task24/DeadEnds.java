package yandex.coderun.random.task24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/dead-ends">task link</a><br>
 * test - OK
 */
public class DeadEnds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] kn = reader.readLine().split(" ");
        int k = Integer.parseInt(kn[0]);
        int n = Integer.parseInt(kn[1]);

        int[] ends = new int[k + 1];
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String[] ab = reader.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            int j = 1;
            for (; j <= k; j++) {
                if (ends[j] < a) {
                    ends[j] = b;
                    out.append(j).append('\n');
                    break;
                }
            }
            if (j == k + 1) {
                writer.write("0 " + i);
                reader.close();
                writer.close();
                return;
            }
        }
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

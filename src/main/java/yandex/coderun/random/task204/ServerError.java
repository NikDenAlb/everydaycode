package yandex.coderun.random.task204;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/server-error">task link</a><br>
 * test - OK
 */
public class ServerError {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            input[i][0] = Integer.parseInt(line[0]);
            input[i][1] = Integer.parseInt(line[1]);
        }
        int sumV = 0;
        for (int[] e : input) {
            sumV += e[0] * e[1];
        }
        StringBuilder out = new StringBuilder();
        for (int[] e : input) {
            out.append((double) e[0] * e[1] / sumV).append("\n");
        }
        out.setLength(out.length() - 1);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

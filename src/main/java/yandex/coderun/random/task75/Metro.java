package yandex.coderun.random.task75;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/metro">task link</a><br>
 * test - OK
 */
public class Metro {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        writer.write(defineWaitTime(a, b, n, m));

        reader.close();
        writer.close();
    }

    static String defineWaitTime(int a, int b, int n, int m) {
        int timeNStart = (1 + a) * (n - 1) + 1;
        int timeNEnd = timeNStart + 2 * a;
        int timeMStart = (1 + b) * (m - 1) + 1;
        int timeMEnd = timeMStart + 2 * b;

        int outStart = Math.max(timeNStart, timeMStart);
        int outEnd = Math.min(timeNEnd, timeMEnd);

        if (outStart > outEnd) {
            return "-1";
        }

        return outStart + " " + outEnd;
    }
}

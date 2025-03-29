package yandex.coderun.random.task77;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
2a+3b+4c+5d         7
------------ >= ---------
a+b+c+d             2

4a+6b+8c+10d >= 7a+7b+7c+7d

3d >= 3a+b-c

        3a+b-c
d >=--------------
          3
*/

/**
 * <a href="https://coderun.yandex.ru/problem/improving-academic-performance">task link</a><br>
 * test - OK
 */
public class ImprovingAcademicPerformanceBinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long a = Long.parseLong(reader.readLine());
        long b = Long.parseLong(reader.readLine());
        long c = Long.parseLong(reader.readLine());

        long d = 1_000_000_000_000_000L;
        for (long left = 0; left < d; ) {
            long mid = (left + d) / 2;
            if ((2 * a + 3 * b + 4 * c + 5 * mid) * 2 >= 7 * (a + b + c + mid)) {
                d = mid;
            } else {
                left = mid + 1;
            }
        }

        writer.write(String.valueOf(d));

        reader.close();
        writer.close();
    }
}

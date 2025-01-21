package yandex.coderun.quickstart.task16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/improving-academic-performance">task link</a><br>
 * test - OK
 */
public class ImprovingAcademicPerformance {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long a = Long.parseLong(reader.readLine());
        long b = Long.parseLong(reader.readLine());
        long c = Long.parseLong(reader.readLine());

        writer.write(String.valueOf((3 * a + b - c + 2) / 3));

        reader.close();
        writer.close();
    }
}

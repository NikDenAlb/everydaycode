package livecoding.coderun.task5202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/season-tasks">task link</a><br>
 * <a href="https://youtu.be/aemVGCkCi_E?si=LmffxY-1JzUX3cCS">video link</a><br>
 */
public class SeasonTasks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        long a = Long.parseLong(line[0]);
        long b = Long.parseLong(line[1]);

        writer.write(String.valueOf(a + b));

        reader.close();
        writer.close();
    }
}

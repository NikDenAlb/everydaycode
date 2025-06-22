package yandex.coderun.random.task306;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * <a href="https://coderun.yandex.ru/problem/dayofweek-ya-intern">task link</a><br>
 * test - OK
 */
public class DayOfWeekYaIntern {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
        String input;
        StringBuilder out = new StringBuilder();
        while ((input = reader.readLine()) != null && !input.isEmpty()) {
            LocalDate date = LocalDate.parse(input, formatter);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            out.append(dayOfWeek.name().charAt(0)).append(dayOfWeek.name().substring(1).toLowerCase()).append('\n');
        }
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

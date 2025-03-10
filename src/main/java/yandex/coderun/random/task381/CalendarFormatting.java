package yandex.coderun.random.task381;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/calendar-formatting">task link</a><br>
 * test - OK
 */
public class CalendarFormatting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int nDays = Integer.parseInt(input[0]);
        int sDay = Day.parseDay(input[1]);

        StringBuilder out = new StringBuilder();
        int day = 1;

        for (int i = 1; i <= 6; i++) {
            if (i < sDay) {
                out.append("..").append(' ');
            } else {
                out.append('.').append(day++).append(' ');
            }
        }
        out.append('.').append(day++).append('\n');
        for (int i = 1; day <= nDays; i++) {
            if (day < 10) {
                out.append('.').append(day++).append(' ');
             } else {
                out.append(day++).append(' ');
            }
            if (i % 7 == 0) {
                out.setCharAt(out.length() - 1, '\n');
            }
        }
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

enum Day {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private final String displayName;

    Day(String displayName) {
        this.displayName = displayName;
    }

    public static int parseDay(String displayName) {
        for (Day day : values()) {
            if (day.displayName.equalsIgnoreCase(displayName)) {
                return day.ordinal() + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}

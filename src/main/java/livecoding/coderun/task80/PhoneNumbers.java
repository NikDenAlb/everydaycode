package livecoding.coderun.task80;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/conditioner">task link</a><br>
 * <a href="https://youtu.be/9gT2w-raaTM">video link</a>
 */
public class PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long numNew = mapNumToLong(reader.readLine());
        long[] book = new long[3];
        for (int i = 0; i < book.length; i++) {
            book[i] = mapNumToLong(reader.readLine());
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < book.length - 1; i++) {
            out.append(numNew == book[i] ? "YES" : "NO").append('\n');
        }
        out.append(numNew == book[2] ? "YES" : "NO");

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static long mapNumToLong(String numS) {
        long num = Long.parseLong(numS.replaceAll("[^0-9]", ""));
        if (num < 1_000_00_00) {
            return num + 8_495_000_00_00L;
        }
        if (num < 8_000_000_00_00L) {
            return num + 1_000_000_00_00L;
        }
        return num;
    }
}

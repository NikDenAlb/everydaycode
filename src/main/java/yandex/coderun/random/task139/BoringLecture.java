package yandex.coderun.random.task139;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/boring-lecture">task link</a><br>
 * test - OK
 */
public class BoringLecture {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = reader.readLine();

        Map<Character, Long> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            long count = (long) (word.length() - i) * (i + 1);
            map.put(letter, map.getOrDefault(letter, 0L) + count);
        }

        StringBuilder out = new StringBuilder();

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> out.append(entry.getKey())
                                                          .append(": ")
                                                          .append(entry.getValue())
                                                          .append('\n'));
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

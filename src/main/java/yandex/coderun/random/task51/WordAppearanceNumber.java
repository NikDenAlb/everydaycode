package yandex.coderun.random.task51;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/word-appearance-number">task link</a><br>
 * test - OK
 */
public class WordAppearanceNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> wordsMap = new HashMap<>();
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            Arrays.asList(line.split(" "))
                    .forEach(word -> {
                        wordsMap.put(word, wordsMap.getOrDefault(word, -1) + 1);
                        out.append(wordsMap.get(word)).append(" ");
                    });
        }
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

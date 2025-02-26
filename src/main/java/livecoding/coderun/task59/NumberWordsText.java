package livecoding.coderun.task59;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://coderun.yandex.ru/problem/number-words-text">task link</a><br>
 * <a href="https://youtu.be/QPSL3wHyO9Q">video link</a>
 */
public class NumberWordsText {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> words = new HashSet<>();
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            words.addAll(List.of(line.split(" ")));
        }

        writer.write(String.valueOf(words.size()));

        reader.close();
        writer.close();
    }
}

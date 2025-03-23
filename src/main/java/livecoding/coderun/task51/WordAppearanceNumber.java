package livecoding.coderun.task51;

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
 * <a href="https://youtu.be/4bnJkENWVfk">video link</a>
 */
public class WordAppearanceNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();
        String line;
        StringBuilder out = new StringBuilder();

        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            Arrays.stream(line.split(" ")).forEach(e -> {
                        out.append(map.getOrDefault(e, 0)).append(' ');
                        map.put(e, map.getOrDefault(e, 0) + 1);
                    }
            );
        }
        if (out.length() > 0) {
            out.setLength(out.length() - 1);
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

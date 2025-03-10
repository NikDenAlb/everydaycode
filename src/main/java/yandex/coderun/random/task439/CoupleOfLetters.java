package yandex.coderun.random.task439;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/couple-of-letters">task link</a><br>
 * test - OK
 */
public class CoupleOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String s : line) {
            if (s.length() >= 2) {
                for (int i = 1; i < s.length(); i++) {
                    map.put(s.substring(i - 1, i + 1), map.getOrDefault(s.substring(i - 1, i + 1), 0) + 1);
                }
            }
        }
        String lastWord = "";
        int maxValue = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int value = entry.getValue();
            if (value > maxValue) {
                maxValue = value;
                lastWord = word;
            } else if (value == maxValue) {
                if (word.compareTo(lastWord) > 0) {
                    lastWord = word;
                }
            }
        }

        writer.write(lastWord);

        reader.close();
        writer.close();
    }
}

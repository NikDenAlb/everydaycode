package livecoding.coderun.task52;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/dictionary-synonyms">task link</a><br>
 * <https://youtu.be/y0lRm9saqVM">video link</a>
 */
public class DictionarySynonyms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            map.put(line[0], line[1]);
            map.put(line[1], line[0]);
        }

        String word = reader.readLine();

        writer.write(map.get(word));

        reader.close();
        writer.close();
    }
}

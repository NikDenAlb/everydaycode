package yandex.coderun.random.task50;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/frequent-word">task link</a><br>
 * test - OK
 */
public class FrequentWord {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        Map<String, Integer> map = new HashMap<>();
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            Arrays.stream(line.split(" ")).forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));
        }

        Integer maxCount = map.values().stream().max(Comparator.comparing(Integer::intValue)).get();
        writer.write(map.keySet().stream().filter(word -> map.get(word).equals(maxCount)).min(String::compareTo).get());

        reader.close();
        writer.close();
    }
}

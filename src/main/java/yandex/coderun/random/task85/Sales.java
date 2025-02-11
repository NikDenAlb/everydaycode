package yandex.coderun.random.task85;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/sales">task link</a><br>
 * test - TL on 79 TODO
 */
public class Sales {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Map<String, Long>> map = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            String[] input = line.split(" ");
            Map<String, Long> inMap = map.getOrDefault(input[0], new HashMap<>());
            inMap.put(input[1], inMap.getOrDefault(input[1], 0L) + Long.parseLong(input[2]));
            map.putIfAbsent(input[0], inMap);
        }

        StringBuilder out = new StringBuilder();

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    out.append(entry.getKey()).append(":").append("\n");
                    entry.getValue().entrySet().stream()
                            .sorted(Map.Entry.comparingByKey())
                            .forEach(innerEntry ->
                                    out.append(innerEntry.getKey()).append(" ").append(innerEntry.getValue()).append("\n")
                            );
                });
        out.setLength(out.length() - 1);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

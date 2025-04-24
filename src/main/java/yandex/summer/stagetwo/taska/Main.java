package yandex.summer.stagetwo.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            String a = line[0] + " " + line[1];
            String b = line[2] + " " + line[3];

            map.put(a, map.getOrDefault(a, 0) + 1);
            map.put(b, map.getOrDefault(b, 0) - 1);
        }

        Optional<String> a = map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();

        if (a.isEmpty()) {
            writer.write("-1");
            reader.close();
            writer.close();
            return;
        }

        Optional<String> b = map.entrySet().stream()
                .filter(entry -> entry.getValue() == -1)
                .map(Map.Entry::getKey)
                .findFirst();

        if (b.isEmpty()) {
            writer.write("-1");
            reader.close();
            writer.close();
            return;
        }

        writer.write(a.get() + " " + b.get());

        reader.close();
        writer.close();
    }
}

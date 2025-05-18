package yandex.coderun.random.task87;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class MayaScript {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] gs = reader.readLine().split(" ");
        int g = Integer.parseInt(gs[0]);
        int s = Integer.parseInt(gs[1]);
        String w = reader.readLine();
        String h = reader.readLine();

        Map<Character, Integer> wMap = new HashMap<>();
        Map<Character, Integer> hMap = new HashMap<>();

        for (int i = 0; i < g; i++) {
            wMap.put(w.charAt(i), wMap.getOrDefault(w.charAt(i), 0) + 1);
            hMap.put(h.charAt(i), hMap.getOrDefault(h.charAt(i), 0) + 1);
        }
        int count = 0;
        if (wMap.equals(hMap)) {
            count++;
        }
        for (int i = g; i < s; i++) {
            if (h.charAt(i - g) != h.charAt(i)) {
                if (hMap.get(h.charAt(i - g)) == 1) {
                    hMap.remove(h.charAt(i - g));
                } else {
                    hMap.put(h.charAt(i - g), hMap.get(h.charAt(i - g)) - 1);
                }
                hMap.put(h.charAt(i), hMap.getOrDefault(h.charAt(i), 0) + 1);
            }
            if (wMap.equals(hMap)) {
                count++;
            }
        }

        writer.write(String.valueOf(count));

        reader.close();
        writer.close();
    }
}

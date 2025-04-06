package yandex.coderun.random.task129;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://coderun.yandex.ru/problem/pedigree-counting-levels">task link</a><br>
 * test - OK
 */
public class PedigreeCountingLevels {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        Map<String, String> dict = new HashMap<>();
        Map<String, List<String>> childList = new HashMap<>();

        for (int i = 1; i < n; i++) {
            String[] line = reader.readLine().split(" ");

            childList.putIfAbsent(line[1], new ArrayList<>());
            List<String> list = childList.get(line[1]);
            list.add(line[0]);

            dict.put(line[0], line[1]);
        }

        String root = dict.values().stream().findAny().orElseThrow();
        while (dict.containsKey(root)) {
            root = dict.get(root);
        }

        Map<String, Integer> heights = getStringIntegerMap(root, childList);

        StringBuilder out = new StringBuilder();
        heights.keySet().stream()
                .sorted()
                .forEach(e -> out.append(e).append(' ').append(heights.get(e)).append('\n'));
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static Map<String, Integer> getStringIntegerMap(String root, Map<String, List<String>> childList) {
        Map<String, Integer> out = new HashMap<>();
        int lvl = 0;
        Set<String> addMap = new HashSet<>(List.of(root));
        while (!addMap.isEmpty()) {
            Set<String> nextList = new HashSet<>();
            final int fLvl = lvl;
            addMap.forEach(e -> {
                if (childList.containsKey(e)) {
                    nextList.addAll(childList.get(e));
                }
                out.put(e, fLvl);
            });
            addMap = nextList;
            lvl++;
        }
        return out;
    }
}

package yandex.coderun.random.task128;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://coderun.yandex.ru/problem/pedigree-number-of-descendants">task link</a><br>
 * test - OK
 */
public class PedigreeNumberOfDescendants {
    static Map<String, List<String>> map;
    static Map<String, Integer> count;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        map = new HashMap<>();
        count = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String[] line = reader.readLine().split(" ");
            String child = line[0];
            String parent = line[1];

            map.computeIfAbsent(parent, e -> new ArrayList<>()).add(child);
            count.putIfAbsent(child, 0);
            count.putIfAbsent(parent, 0);
        }

        Set<String> allChildren = new HashSet<>();
        for (List<String> children : map.values()) {
            allChildren.addAll(children);
        }

        for (String parent : map.keySet()) {
            if (!allChildren.contains(parent)) {
                countDescendants(parent);
                break;
            }
        }

        List<String> sortedNames = new ArrayList<>(count.keySet());
        Collections.sort(sortedNames);
        StringBuilder out = new StringBuilder();
        for (String name : sortedNames) {
            out.append(name).append(" ").append(count.get(name)).append('\n');
        }
        if (!out.isEmpty()) {
            out.setLength(out.length() - 1);
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static int countDescendants(String node) {
        List<String> children = map.get(node);
        if (children == null) {
            return 0;
        }

        int cnt = 0;
        for (String child : children) {
            cnt += 1 + countDescendants(child);
        }
        count.put(node, cnt);
        return cnt;
    }
}

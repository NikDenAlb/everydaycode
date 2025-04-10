package yandex.coderun.random.task8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/connectivity-components">task link</a><br>
 * test - OK
 */
public class ConnectivityComponents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            line = reader.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            g.get(a).add(b);
            g.get(b).add(a);
        }

        int[] used = new int[n + 1]; //used[0] - count for components
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (used[i] == 0) {
                used[i] = ++used[0];
                map.put(used[0], new ArrayList<>(List.of(i)));
                List<Integer> newV = new ArrayList<>(List.of(i));
                while (!newV.isEmpty()) {
                    int v = newV.removeLast();
                    g.get(v).forEach(e -> {
                        if (used[e] == 0) {
                            used[e] = used[0];
                            newV.add(e);
                            map.get(used[0]).add(e);
                        }
                    });
                }
            }
        }

        StringBuilder out = new StringBuilder();
        out.append(used[0]).append('\n');
        for (int i = 1; i <= used[0]; i++) {
            out.append(map.get(i).size()).append('\n');
            map.get(i).forEach(e -> out.append(e).append(' '));
            out.setCharAt(out.length() - 1, '\n');
        }
        out.setLength(out.length() - 1);

        if (used[0] > 0) {
            writer.write(out.toString());
        }

        reader.close();
        writer.close();
    }
}

package yandex.coderun.random.task8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://coderun.yandex.ru/problem/connectivity-components">task link</a><br>
 * test - TL
 */
public class ConnectivityComponentsTL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (int i = 0; i < m; i++) {
            line = reader.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            edges.putIfAbsent(a, new HashSet<>());
            edges.get(a).add(b);
            edges.putIfAbsent(b, new HashSet<>());
            edges.get(b).add(a);
        }

        Set<Integer> verts = IntStream.range(1, n + 1).boxed().collect(Collectors.toSet());
        StringBuilder out = new StringBuilder();
        int count = 0;
        while (!verts.isEmpty()) {
            Set<Integer> connected = new HashSet<>(Set.of(verts.iterator().next()));
            verts.removeAll(connected);
            Set<Integer> newConnected = new HashSet<>(connected);
            while (!newConnected.isEmpty()) {
                newConnected = newConnected.stream().filter(edges::containsKey).map(edges::get).flatMap(Collection::stream).filter(e -> !connected.contains(e)).collect(Collectors.toSet());
                connected.addAll(newConnected);
                verts.removeAll(newConnected);
            }
            out.append(connected.size()).append("\n");
            connected.forEach(e -> out.append(e).append(" "));
            out.append("\n");
            count++;
        }
        out.setLength(out.length() - 1);
        out.insert(0, count + "\n");
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

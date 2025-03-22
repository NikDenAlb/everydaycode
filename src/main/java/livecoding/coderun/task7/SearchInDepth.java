package livecoding.coderun.task7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/search-in-depth">task link</a><br>
 * <a href="https://youtu.be/Yf3eXWq_Uwo">video link</a>
 */
public class SearchInDepth {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int k = Integer.parseInt(input[1]);

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.put(1, new HashSet<>(List.of(1)));

        for (int i = 0; i < k; i++) {
            String[] edge = reader.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph.putIfAbsent(a, new HashSet<>());
            graph.putIfAbsent(b, new HashSet<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Set<Integer> connV1 = new HashSet<>(List.of(1));
        Set<Integer> addConn = new HashSet<>(List.of(1));

        while (!addConn.isEmpty()) {
            Set<Integer> newConn = addConn.stream().flatMap(e -> graph.get(e).stream()).collect(Collectors.toSet());
            newConn.removeAll(connV1);
            addConn = newConn;
            connV1.addAll(newConn);
        }

        StringBuilder out = new StringBuilder();
        out.append(connV1.size()).append('\n');
        connV1.stream().sorted().forEach(e -> out.append(e).append(' '));
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

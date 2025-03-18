package yandex.coderun.quickstart.task18;

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

public class Rework {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] stringNM = reader.readLine().split(" ");
        int m = Integer.parseInt(stringNM[1]);

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.put(1, new HashSet<>(List.of(1)));
        for (int i = 0; i < m; i++) {
            String[] string = reader.readLine().split(" ");
            int a = Integer.parseInt(string[0]);
            int b = Integer.parseInt(string[1]);
            graph.putIfAbsent(a, new HashSet<>());
            graph.putIfAbsent(b, new HashSet<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Set<Integer> connV1 = new HashSet<>();
        Set<Integer> newConn = new HashSet<>();
        newConn.add(1);
        while (!newConn.isEmpty()) {
            Set<Integer> addConn = newConn.stream().flatMap(e -> graph.get(e).stream()).collect(Collectors.toSet());
            addConn.removeAll(connV1);
            connV1.addAll(addConn);
            newConn = addConn;
        }

        StringBuilder out = new StringBuilder();
        out.append(connV1.size()).append("\n");
        if (!connV1.isEmpty()) {
            connV1.stream().sorted().forEach(e -> out.append(e).append(" "));
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

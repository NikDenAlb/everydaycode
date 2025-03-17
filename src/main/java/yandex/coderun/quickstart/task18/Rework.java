package yandex.coderun.quickstart.task18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//TODO Morning

public class Rework {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] stringNM = reader.readLine().split(" ");
        int n = Integer.parseInt(stringNM[0]);
        int m = Integer.parseInt(stringNM[1]);

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            String[] string = reader.readLine().split(" ");
            int a = Integer.parseInt(string[0]) - 1;
            int b = Integer.parseInt(string[1]) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Set<Integer> connV1 = new HashSet<>(List.of(0));
        Set<Integer> newConn = new HashSet<>(List.of(0));
        Set<Integer> addConn = newConn.stream().flatMap(e -> graph.get(e).stream()).collect(Collectors.toSet());
        while (!newConn.isEmpty()) {
            addConn.removeAll(connV1);
            connV1.addAll(addConn);
            newConn = new HashSet<>(addConn);
        }
        StringBuilder out = new StringBuilder();
        out.append(connV1.size()).append("\n");
        if (!connV1.isEmpty()) {
            connV1.stream().sorted().forEach(e -> out.append(e + 1).append(" "));
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

}

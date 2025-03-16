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

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        Set<Integer> connV1 = new HashSet<>(List.of(0));
        Set<Integer> newConn = new HashSet<>(List.of(0));
        Set<Integer> addConn = newConn.stream().flatMap(e->graph.get(e).stream()).collect(Collectors.toSet());











        reader.close();
        writer.close();
    }

}

package yandex.algorithms7.warm.taskI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * test - OK
 */
public class SubtreeSize {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(reader.readLine());

        List<List<Integer>> graph = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < v - 1; i++) {
            String[] line = reader.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] sizes = new int[v];

        dfs(0, -1, graph, sizes);

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < v; i++) {
            out.append(sizes[i]).append(' ');
        }
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static int dfs(int node, int parent, List<List<Integer>> graph, int[] sizes) {
        int size = 1;
        for (int next : graph.get(node)) {
            if (next != parent) {
                size += dfs(next, node, graph, sizes);
            }
        }
        sizes[node] = size;
        return size;
    }
}

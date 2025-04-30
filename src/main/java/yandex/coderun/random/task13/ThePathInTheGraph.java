package yandex.coderun.random.task13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/the-path-in-the-graph">task link</a><br>
 * test - OK
 */
public class ThePathInTheGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toList());
        }
        String[] ab = reader.readLine().split(" ");
        int a = Integer.parseInt(ab[0]) - 1;
        int b = Integer.parseInt(ab[1]) - 1;

        int[] dist = new int[n];
        dist[a] = 1;

        int[] prev = new int[n];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(a);

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (int i = 0; i < n; i++) {
                if (graph.get(cur).get(i) == 1 && dist[i] == 0) {
                    dist[i] = dist[cur] + 1;
                    prev[i] = cur;
                    if (i == b) {
                        break;
                    }
                    q.add(i);
                }
            }
        }

        if (dist[b] == 0) {
            writer.write("-1");

            reader.close();
            writer.close();
            return;
        }

        if (dist[b] == 1) {
            writer.write("0");

            reader.close();
            writer.close();
            return;
        }

        List<Integer> path = new ArrayList<>(List.of(b + 1));

        for (int i = prev[b]; i != a; i = prev[i]) {
            path.add(i + 1);
        }
        path.add(a + 1);

        writer.write(dist[b] - 1 + "\n");
        writer.write(path.reversed().stream().map(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}

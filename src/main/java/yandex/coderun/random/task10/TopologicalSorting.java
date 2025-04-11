package yandex.coderun.random.task10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/topological-sorting">task link</a><br>
 * test - OK
 */
public class TopologicalSorting {
    static List<List<Integer>> g;
    static int[] vis;
    static List<Integer> res;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] edge = reader.readLine().split(" ");
            int u = Integer.parseInt(edge[0]) - 1;
            int v = Integer.parseInt(edge[1]) - 1;
            g.get(u).add(v);
        }

        vis = new int[n];
        res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                if (dfs(i)) {
                    writer.write("-1");
                    reader.close();
                    writer.close();
                    return;
                }
            }
        }

        Collections.reverse(res);

        writer.write(res.stream().map(e -> e + 1).map(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }

    static boolean dfs(int node) {
        // 0 - new, 1 - doing, 2 - done
        if (vis[node] == 1) {
            return true;
        }
        if (vis[node] == 2) {
            return false;
        }
        vis[node] = 1;
        for (int neighbor : g.get(node)) {
            if (dfs(neighbor)) {
                return true;
            }
        }
        vis[node] = 2;
        res.add(node);
        return false;
    }
}

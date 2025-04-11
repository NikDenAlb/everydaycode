package yandex.coderun.random.task39;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/first-vertex">task link</a><br>
 * test - OK
 */
public class FirstVertex {
    static List<List<Integer>> g;
    static boolean[] vis;

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
            int a = Integer.parseInt(edge[0]) - 1;
            int b = Integer.parseInt(edge[1]) - 1;
            g.get(b).add(a);
        }

        vis = new boolean[n];
        dfs(0);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                ans.add(i);
            }
        }

        writer.write(ans.stream()
                .sorted()
                .map(e -> e + 1)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }

    static void dfs(int node) {
        vis[node] = true;
        for (int neighbor : g.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}

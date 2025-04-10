package yandex.coderun.random.task9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://coderun.yandex.ru/problem/cheating">task link</a><br>
 * test - OK
 */
public class Cheating {
    static List<List<Integer>> g;
    static int[] col;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] uv = reader.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            g.get(u).add(v);
            g.get(v).add(u);
        }

        col = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (col[i] == 0) {
                if (dfs(i, 1)) {
                    writer.write("NO");
                    reader.close();
                    writer.close();
                    return;
                }
            }
        }

        writer.write("YES");

        reader.close();
        writer.close();
    }

    static boolean dfs(int node, int color) {
        col[node] = color;
        for (int neighbor : g.get(node)) {
            if (col[neighbor] == 0) {
                if (dfs(neighbor, -color)) {
                    return true;
                }
            } else if (col[neighbor] == color) {
                return true;
            }
        }
        return false;
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PiggyBanks {
    static boolean[] visited;
    static List<List<Integer>> g;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        visited = new boolean[n];
        for (int a = 0; a < n; a++) {
            int b = Integer.parseInt(reader.readLine()) - 1;
            g.get(a).add(b);
            g.get(b).add(a);
        }

        int out = 0;
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                dfs(v);
                out++;
            }
        }

        writer.write(String.valueOf(out));

        reader.close();
        writer.close();
    }

    static void dfs(int a) {
        visited[a] = true;
        for (Integer b : g.get(a)) {
            if (!visited[b]) {
                dfs(b);
            }
        }
    }
}

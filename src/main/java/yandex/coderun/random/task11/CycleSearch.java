package yandex.coderun.random.task11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a href="https://coderun.yandex.ru/problem/cycle-search">task link</a><br>
 * test - OK
 */
public class CycleSearch {
    static int n;
    static int[] vstd;
    static List<List<Integer>> g;
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        g = new ArrayList<>();
        vstd = new int[n];
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("1")) {
                    g.get(i).add(j);
                }
            }
        }

        if (!hasCircle()) {
            writer.write("NO");
            reader.close();
            writer.close();
            return;
        }

        StringBuilder out = new StringBuilder();

        List<Integer> ans = new ArrayList<>();
        int end = stack.pop() + 1;
        do {
            ans.add(stack.pop() + 1);
        } while (ans.getLast() != end);

        out.append("YES").append('\n');
        out.append(ans.size()).append('\n');
        ans.forEach(e -> out.append(e).append(' '));
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static boolean hasCircle() {
        for (int i = 0; i < n; i++) {
            if (vstd[i] == -1) {
                continue;
            }
            if (dfs(i, -1)) {
                return true;
            }
        }
        return false;
    }

    static boolean dfs(int v, int p) {
        vstd[v] = 1;
        stack.push(v);
        for (int u : g.get(v)) {
            if (u == p) {
                continue;
            }
            if (vstd[u] == 1) {
                stack.push(u);
                return true;
            }
            if (dfs(u, v)) {
                return true;
            }
        }
        vstd[v] = -1;
        stack.pop();
        return false;
    }
}

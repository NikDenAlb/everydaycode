import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class GraphCutting {
    static List<List<Integer>> g = new ArrayList<>();
    static List<Boolean> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmk = reader.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>(List.of(i)));
        }

        for (int i = 0; i < m; i++) {
            reader.readLine();
        }
        String[] cmds = new String[k];
        for (int i = cmds.length - 1; i >= 0; i--) {
            cmds[i] = reader.readLine();
        }
        for (String cmd : cmds) {
            execute(cmd);
        }

        StringBuilder out = new StringBuilder();
        if (!ans.isEmpty()) {
            for (int i = ans.size() - 1; i >= 0; i--) {
                out.append(ans.get(i) ? "YES" : "NO").append('\n');
            }
            out.setLength(out.length() - 1);
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static void execute(String cmd) {
        String[] subCmds = cmd.split(" ");
        switch (subCmds[0]) {
            case "ask" -> ask(Integer.parseInt(subCmds[1]) - 1, Integer.parseInt(subCmds[2]) - 1);
            case "cut" -> add(Integer.parseInt(subCmds[1]) - 1, Integer.parseInt(subCmds[2]) - 1);
            default -> throw new IllegalStateException();
        }
    }

    static void ask(int a, int b) {
        ans.add(g.get(a) == g.get(b));
    }

    static void add(int a, int b) {
        if (g.get(a) != g.get(b)) {
            if (g.get(a).size() > g.get(b).size()) {
                g.get(a).addAll(g.get(b));
                for (Integer e : g.get(b)) {
                    g.set(e, g.get(a));
                }
            } else {
                g.get(b).addAll(g.get(a));
                for (Integer e : g.get(a)) {
                    g.set(e, g.get(b));
                }
            }
        }
    }
}

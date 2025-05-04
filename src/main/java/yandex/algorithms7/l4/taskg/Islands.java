import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Islands {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>(List.of(i)));
        }

        int count = 1;
        for (; count < m ; count++) {
            String[] ab = reader.readLine().split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;

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
                if (g.getFirst().size() == n) {
                    break;
                }
            }
        }

        writer.write(String.valueOf(count));

        reader.close();
        writer.close();
    }
}

package yandex.coderun.random.task11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CycleSearchBroken {
    static int[] vstd;
    static List<Set<Integer>> g;
    static int n;
    static int cStart;
    static int cEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        g = new ArrayList<>();
        vstd = new int[n];
        Arrays.fill(vstd, -1);

        for (int i = 0; i < n; i++) {
            g.add(new HashSet<>());
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("1")) {
                    g.get(i).add(j);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(yesNo());
        if (ans.length() < 3) {
            writer.write(ans.toString());
            reader.close();
            writer.close();
            return;
        }
        ans.append('\n');
       // System.out.println(Arrays.toString(vstd));
      //  System.out.println("cStart = " + cStart);
       // System.out.println("cEnd = " + cEnd);

        List<Integer> out = new ArrayList<>();
        int v = vstd[cEnd];
        out.add(cStart);
        out.add(cEnd);
        vstd[cStart] = -1;
        vstd[cEnd] = -1;
        while (vstd[v] != -1) {
            out.add(v);
            v = vstd[v];
            vstd[v] = -1;
        }

      //  System.out.println(Arrays.toString(vstd));

        ans.append(out.size()).append('\n');
        ans.append(out.stream().map(e -> e + 1).map(String::valueOf).collect(Collectors.joining(" ")));

        writer.write(ans.toString());

        reader.close();
        writer.close();
    }

    static String yesNo() {
        for (int i = 0; i < n; i++) {
            if (vstd[i] != -1) {
                continue;
            }
            List<Integer> step = new ArrayList<>(List.of(i));
            vstd[i] = i;
            while (!step.isEmpty()) {
                List<Integer> newStep = new ArrayList<>();

                for (Integer vFrom : step) {
                    List<Integer> removeList = new ArrayList<>();
                    for (Integer vTo : g.get(vFrom)) {
                        if (vstd[vTo] > -1) {
                            cStart = vTo;
                            cEnd = vFrom;
                            return "YES";
                        } else {
                            newStep.add(vTo);
                            removeList.add(vTo);
                            vstd[vTo] = vFrom;
                        }
                    }
                    for (Integer vTo : removeList) {
                        g.get(vFrom).remove(vTo);
                        g.get(vTo).remove(vFrom);
                    }
                }
                step = newStep;
            }
        }
        return "NO";
    }
}

package yandex.coderun.random.task60;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://coderun.yandex.ru/problem/cubes">task link</a><br>
 * test - OK
 */
public class Cubes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        Set<Integer> nSet = new HashSet<>(), mSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nSet.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < m; i++) {
            mSet.add(Integer.parseInt(reader.readLine()));
        }

        Set<Integer> inSet = new HashSet<>(nSet);
        inSet.retainAll(mSet);
        StringBuilder out = new StringBuilder();

        out.append(inSet.size()).append("\n");
        inSet.stream().sorted().forEach(e -> out.append(e).append(" "));
        out.setLength(out.length() - 1);
        out.append("\n");

        nSet.removeAll(inSet);
        out.append(nSet.size()).append("\n");
        nSet.stream().sorted().forEach(e -> out.append(e).append(" "));
        out.setLength(out.length() - 1);
        out.append("\n");

        mSet.removeAll(inSet);
        out.append(mSet.size()).append("\n");
        mSet.stream().sorted().forEach(e -> out.append(e).append(" "));
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

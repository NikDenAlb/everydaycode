package yandex.coderun.hrtechinterview.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://coderun.yandex.ru/selections/hr-tech-interview/problems/polyglots">task link</a><br>
 * test - OK
 */
public class Polyglots {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        reader.readLine();
        String s = reader.readLine();
        Set<String> setGlobal = new HashSet<>();
        Set<String> setAll = new HashSet<>();

        while (!s.matches("\\d+")) {
            setAll.add(s);
            setGlobal.add(s);
            s = reader.readLine();
        }
        for (int i = 1; i < n; i++) {
            Set<String> set = new HashSet<>();
            s = reader.readLine();
            while (s != null && !s.matches("\\d+") && !s.isEmpty()) {
                set.add(s);
                setGlobal.add(s);
                s = reader.readLine();
            }
            setAll.retainAll(set);
        }

        StringBuilder out = new StringBuilder();
        out.append(setAll.size()).append("\n");
        setAll.forEach(e->out.append(e).append("\n"));
        out.append(setGlobal.size()).append("\n");
        setGlobal.forEach(e->out.append(e).append("\n"));
        out.setLength(out.length()-1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

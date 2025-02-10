package yandex.coderun.random.task83;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/keyboard">task link</a><br>
 * test - OK
 */
public class Keyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();
        int[] c = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        reader.readLine();
        int[] p = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> map = new HashMap<>();
        for (int e : p) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < c.length; i++) {
            out.append(map.getOrDefault(i + 1, 0) > c[i] ? "YES" : "NO").append("\n");
        }
        out.setLength(out.length() - 1);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

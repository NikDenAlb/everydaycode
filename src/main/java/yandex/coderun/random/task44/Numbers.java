package yandex.coderun.random.task44;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * <a href="https://coderun.yandex.ru/problem/numbers">task link</a><br>
 * test - OK
 */
public class Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String start = reader.readLine();
        String end = reader.readLine();

        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        Map<String, String> parent = new HashMap<>();
        parent.put(start, "");

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            if (curr.equals(end)) {
                break;
            }

            List<String> states = new ArrayList<>();
            if (curr.charAt(0) < '9') {
                states.add((char) (curr.charAt(0) + 1) + curr.substring(1));
            }
            if (curr.charAt(3) > '1') {
                states.add(curr.substring(0, 3) + (char) (curr.charAt(3) - 1));
            }
            states.add(curr.charAt(3) + curr.substring(0, 3));
            states.add(curr.substring(1) + curr.charAt(0));

            for (String state : states) {
                if (!visited.contains(state)) {
                    queue.add(state);
                    visited.add(state);
                    parent.put(state, curr);
                }
            }
        }

        List<String> path = new ArrayList<>();
        String curr = end;
        while (!curr.isEmpty()) {
            path.add(curr);
            curr = parent.get(curr);
        }

        writer.write(String.join("\n", path.reversed()));

        reader.close();
        writer.close();
    }
}

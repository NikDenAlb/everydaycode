package yandex.coderun.random.task23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://coderun.yandex.ru/problem/goblins-and-chess">task link</a><br>
 * test - OK
 */
public class GoblinsAndChess {
    static List<Integer> queue;
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        queue = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            executeCmd(reader.readLine().split(" "));
        }
        if (!out.isEmpty()) {
            out.setLength(out.length() - 1);
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static void executeCmd(String[] cmd) {
        switch (cmd[0]) {
            case "+" -> addQuery(Integer.parseInt(cmd[1]));
            case "*" -> addQueryVIP(Integer.parseInt(cmd[1]));
            case "-" -> poll();
            default -> throw new RuntimeException();
        }
    }

    static void addQuery(int id) {
        queue.add(id);
    }

    static void addQueryVIP(int id) {
        int mid = queue.size() % 2 == 0 ? queue.size() / 2 : queue.size() / 2 + 1;
        queue.add(mid, id);
    }

    static void poll() {
        out.append(queue.getFirst()).append('\n');
        queue.removeFirst();
    }
}

package yandex.coderun.random.task146;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <a href="https://coderun.yandex.ru/problem/drunkard-game">task link</a><br>
 * test - OK
 */
public class DrunkardGame {
    static Queue<Integer> first;
    static Queue<Integer> second;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        first = new ArrayDeque<>(Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toList());
        second = new ArrayDeque<>(Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toList());

        for (int i = 1; i <= 10e6; i++) {
            if (play()) {
                writer.write(first.isEmpty() ? "second " + i : "first " + i);
                reader.close();
                writer.close();
                return;
            }
        }

        writer.write("botva");

        reader.close();
        writer.close();
    }

    static boolean play() {
        int e1 = first.poll();
        int e2 = second.poll();

        if (e2 == 0 && e1 == 9) {
            second.add(e1);
            second.add(e2);
            return first.isEmpty() || second.isEmpty();
        }

        if (e1 == 0 && e2 == 9) {
            first.add(e1);
            first.add(e2);
            return first.isEmpty() || second.isEmpty();
        }

        if (e1 > e2) {
            first.add(e1);
            first.add(e2);
        } else {
            second.add(e1);
            second.add(e2);
        }
        return first.isEmpty() || second.isEmpty();
    }
}

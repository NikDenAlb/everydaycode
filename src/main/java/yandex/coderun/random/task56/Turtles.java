package yandex.coderun.random.task56;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://coderun.yandex.ru/problem/turtles">task link</a><br>
 * test - OK
 */
public class Turtles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Set<Turtle> setIdeal = new HashSet<>();
        List<Turtle> turtles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            setIdeal.add(new Turtle(i, n - 1 - i));
            String[] line = reader.readLine().split(" ");
            turtles.add(new Turtle(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
        setIdeal.retainAll(turtles);

        writer.write(String.valueOf(setIdeal.size()));

        reader.close();
        writer.close();
    }
}

record Turtle(int a, int b) {}

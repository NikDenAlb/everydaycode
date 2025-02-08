package yandex.algorithms1.part3Sets.taskg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
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

class Turtle {
    final int a;
    final int b;

    Turtle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Turtle turtle = (Turtle) o;
        return a == turtle.a && b == turtle.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}

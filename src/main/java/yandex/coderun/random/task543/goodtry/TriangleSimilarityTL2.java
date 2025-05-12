package yandex.coderun.random.task543.goodtry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://coderun.yandex.ru/problem/triangle-similarity">task link</a><br>
 * test - TL
 */
public class TriangleSimilarityTL2 {
    static Set<Triangle> triangles = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            triangles.add(new Triangle(a, b, c));
        }

        writer.write(String.valueOf(triangles.size()));

        writer.close();
    }
}

record Triangle(int a, int b, int c) {
    Triangle(int a, int b, int c) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        if (b > c) {
            int t = b;
            b = c;
            c = t;
        }
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }

        int g = gcd(a, gcd(b, c));
        this.a = a / g;
        this.b = b / g;
        this.c = c / g;
    }

    int gcd(int x, int y) {
        while (y != 0) {
            int t = y;
            y = x % y;
            x = t;
        }
        return x;
    }
}

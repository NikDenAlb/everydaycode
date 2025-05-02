package yandex.algorithms7.l3.taskg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FenwickTree {
    static StringBuilder out = new StringBuilder();

    static int n;
    static long[] tree;

    static void get(int a, int b) {
        if (a == 0) {
            out.append(sum(b)).append('\n');
            return;
        }
        out.append(sum(b) - sum(--a)).append('\n');
    }

    static long sum(int index) {
        long out = 0;

        while (index >= 0) {
            out += tree[index];
            index = (index & (index + 1)) - 1;
        }
        return out;
    }

    static void set(int index, long value) {
        if (index == 0) {
            value -= tree[index];
        } else {
            value -= sum(index) - sum(index - 1);
        }
        setOnOld(index, value);
    }

    static void setOnOld(int index, long value) {
        while (index < n) {
            tree[index] += value;
            index |= index + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 8388608);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 8388608);

        String[] nk = reader.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        tree = new long[n];
        int k = Integer.parseInt(nk[1]);

        for (int i = 0; i < k; i++) {
            execute(reader.readLine().split(" "));
        }

        if (!out.isEmpty()) {
            out.setLength(out.length() - 1);
        }
        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static void execute(String[] cmd) {
        switch (cmd[0]) {
            case "A" -> set(Integer.parseInt(cmd[1]) - 1, Integer.parseInt(cmd[2]));
            case "Q" -> get(Integer.parseInt(cmd[1]) - 1, Integer.parseInt(cmd[2]) - 1);
            default -> throw new RuntimeException();
        }
    }
}

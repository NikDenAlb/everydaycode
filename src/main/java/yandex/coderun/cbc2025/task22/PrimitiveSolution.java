package yandex.coderun.cbc2025.task22;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PrimitiveSolution {
    int[] calculateAnswer(int n, int[] a) {
        int[] out = new int[n];
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                int s = j;
                boolean[] vstd = new boolean[n];
                vstd[i - 1] = true;
                while (s != -1 && !vstd[s - 1]) {
                    vstd[s - 1] = true;
                    s = a[s - 1];
                }
                if (s == i) {
                    cnt++;
                }
            }
            out[i - 1] = cnt;
        }
        return out;
    }

    // ввод/вывод
    // не изменяйте сигнатуру метода
    public void solve() throws IOException {
        try (var input = new FastInput(System.in)) {
            try (var out = new PrintWriter(System.out)) {
                int t = input.readInt();
                for (int test = 0; test < t; ++test) {
                    int n = input.readInt();
                    int[] a = input.readIntArray(n);
                    int[] answer = calculateAnswer(n, a);
                    out.println(Arrays.stream(answer).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
                }
            }
        }
    }

    static class FastInput implements AutoCloseable {

        BufferedReader in;
        StringTokenizer tok;

        public FastInput(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
            this.tok = new StringTokenizer("");
        }

        public String readLine() {
            try {
                return in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public String readToken() {
            while (!tok.hasMoreTokens()) {
                String nextLine = readLine();
                if (null == nextLine) return null;
                tok = new StringTokenizer(nextLine);
            }

            return tok.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(readToken());
        }

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; ++i) {
                array[i] = readInt();
            }

            return array;
        }

        @Override
        public void close() throws IOException {
            in.close();
        }
    }

    public static void main(String[] args) throws IOException {
        PrimitiveSolution solution = new PrimitiveSolution();
        solution.solve();
    }
}
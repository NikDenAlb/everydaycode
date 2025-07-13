package yandex.coderun.cbc2025.task19;

import java.io.*;
import java.util.*;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/broken-ring">task link</a><br>
 * test - OK
 */
public class Solution {

    // ввод/вывод
    // не изменяйте сигнатуру метода
    public void solve() throws IOException {
        try (FastInput input = new FastInput(System.in)) {
            int tasks = input.readInt();

            for (int i = 0; i < tasks; i++) {
                int n = input.readInt();
                int[] a = input.readIntArray(n);
                int[] b = input.readIntArray(n);
                System.out.println(calcMinCost(a, b, n));
            }
        }
    }

    long calcMinCost(int[] a, int[] b, int n) {
        long out = 0;
        boolean[] vstd = new boolean[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            if (vstd[i]) {
                continue;
            }
            vstd[i] = true;
            cnt++;
            int add = b[i];
            int next = a[i] - 1;
            while (!vstd[next]) {
                vstd[next] = true;
                cnt++;
                add = Math.min(add, b[next]);
                next = a[next] - 1;
            }
            if (cnt == n) {
                return 0;
            }
            out += add;
        }
        return out;
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
        Solution solution = new Solution();
        solution.solve();
    }
}
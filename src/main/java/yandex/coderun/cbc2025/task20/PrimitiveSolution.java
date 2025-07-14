package yandex.coderun.cbc2025.task20;

import java.io.*;
import java.util.*;

public class PrimitiveSolution {
    long calculateAnswer(int n, int k, int[] a) {
        List<Integer> list = new ArrayList<>();
        for (int i : a) {
            if (i % k == 0) {
                list.add(i / k);
            }
        }
        long out = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int i1 = i + 1; i1 < list.size(); i1++) {
                if (gcd(list.get(i), list.get(i1)) == 1) {
                    out++;
                }
            }
        }
        return out;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // ввод/вывод
    // не изменяйте сигнатуру метода
    public void solve() throws IOException {
        try (var input = new FastInput(System.in)) {
            try (var out = new PrintWriter(System.out)) {
                int t = input.readInt();
                for (int test = 0; test < t; ++test) {
                    int n = input.readInt();
                    int k = input.readInt();
                    int[] a = input.readIntArray(n);
                    long answer = calculateAnswer(n, k, a);
                    out.println(answer);
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
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculateAnswer(3, 1, new int[]{1, 3, 2}));
        //3
        System.out.println(solution.calculateAnswer(6, 2, new int[]{4, 4, 1, 3, 2, 6}));
        //5
        System.out.println(solution.calculateAnswer(3, 1, new int[]{1, 1, 1}));
        //3
        System.out.println(solution.calculateAnswer(2, 2, new int[]{1, 2}));
        //0
        System.out.println(solution.calculateAnswer(5, 3, new int[]{1, 4, 2, 5, 2}));
        //0

        System.out.println("------------------------------");

        System.out.println(solution.calculateAnswer(5, 1, new int[]{2, 3, 5, 7, 11}));
        System.out.println(solution.calculateAnswer(5, 2, new int[]{2, 3, 5, 7, 11}));

    }
}
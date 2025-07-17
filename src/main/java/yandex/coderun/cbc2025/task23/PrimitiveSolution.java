package yandex.coderun.cbc2025.task23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class PrimitiveSolution {
    public int[] calculateAnswer(int n, int[] a) {
        int minMax = Integer.MAX_VALUE;
        int maxMax = Integer.MIN_VALUE;
        int minMin = Integer.MAX_VALUE;
        int maxMin = Integer.MIN_VALUE;

        for (int l = 0; l < a.length; l++) {
            for (int r = l; r < a.length; r++) {
                int[] newA = modifyA(a, l, r);
                int newMax = Arrays.stream(newA).max().orElseThrow();
                int newMin = Arrays.stream(newA).min().orElseThrow();
                minMax = Math.min(minMax, newMax);
                maxMax = Math.max(maxMax, newMax);
                minMin = Math.min(minMin, newMin);
                maxMin = Math.max(maxMin, newMin);
            }
        }
        return new int[]{minMax, maxMax, minMin, maxMin};
    }

    int[] modifyA(int[] a, int l, int r) {
        int max = a[l];
        for (int i = l + 1; i <= r; i++) {
            max = Math.max(max, a[i]);
        }
        int[] result = new int[r - l + 1];
        System.arraycopy(a, l, result, 0, r - l + 1);
        Arrays.sort(result);
        int stopVal = max;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] < stopVal - 1) {
                break;
            }
            if (result[i] == stopVal - 1) {
                stopVal = result[i];
            }
        }
        if (stopVal == 0) {
            max++;
        } else {
            max = stopVal - 1;
        }
        int[] out = Arrays.copyOf(a, a.length);
        for (int i = l; i <= r; i++) {
            out[i] = max;
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
        System.out.println(Arrays.toString(solution.calculateAnswer(1, new int[]{1})));
        //0 0 0 0
        System.out.println(Arrays.toString(solution.calculateAnswer(2, new int[]{0, 1})));
        //0 2 0 2
        System.out.println(Arrays.toString(solution.calculateAnswer(3, new int[]{0, 0, 0})));
        //1 1 0 1
        System.out.println(Arrays.toString(solution.calculateAnswer(4, new int[]{0, 0, 1, 2})));
        //0 3 0 3
        System.out.println(Arrays.toString(solution.calculateAnswer(5, new int[]{4, 3, 0, 2, 1})));
        //1 5 0 5
        System.out.println(Arrays.toString(solution.calculateAnswer(6, new int[]{4, 1, 0, 2, 3, 1})));
        //3 5 0 5
    }
}
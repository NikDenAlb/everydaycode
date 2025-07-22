package yandex.coderun.cbc2025.task23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class SolutionUndone {
    int[] prefLMax;
    int[] prefRMax;

    int minMax;
    int maxMax;
    int minMin = 0;
    int maxMin;

    public int[] calculateAnswer(int n, int[] a) {
        if (a.length == 1) {
            if (a[0] == 0) {
                a[0] = 1;
            } else {
                a[0] = 0;
            }
            return new int[]{a[0], a[0], a[0], a[0]};
        }

        //[minMax] [maxMax]                  [minMin]   [maxMin]
        //[]       [Math.max(max,fullMod)]   [always 0] [fullMod]

        int max = Arrays.stream(a).max().orElseThrow();
        int min = Arrays.stream(a).min().orElseThrow();

        int l = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                l = i;
                break;
            }
        }
        int r = -1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == max) {
                r = i;
                break;
            }
        }

        int[] modification = new int[max + 1];
        for (int i = l; i <= r; i++) {
            modification[a[i]]++;
        }

        //should be shorted to [0,l), (r,n)
        prefLMax = new int[n];
        prefLMax[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= l; i++) {
            prefLMax[i] = Math.max(prefLMax[i - 1], a[i - 1]);
        }
        prefRMax = new int[n];
        prefRMax[n - 1] = Integer.MIN_VALUE;
        for (int i = a.length - 2; i >= r; i--) {
            prefRMax[i] = Math.max(prefRMax[i + 1], a[i + 1]);
        }
//-------------------------------------------
        minMax = Math.max(calkMod(modification), Math.max(prefLMax[l], prefRMax[r]));
        int[] modificationCopy = Arrays.copyOf(modification, modification.length);
        for (int j = r + 1; j < n; j++) {
            modificationCopy[a[j]]++;
            minMax = Math.min(minMax, Math.max(calkMod(modificationCopy), Math.max(prefLMax[l], prefRMax[j])));
        }
//-------------------------------------------
        for (int i = l - 1; i >= 0; i--) {
            modification[a[i]]++;
            minMax = Math.min(minMax, Math.max(calkMod(modification), Math.max(prefLMax[i], prefRMax[r])));

            modificationCopy = Arrays.copyOf(modification, modification.length);
            for (int j = r + 1; j < n; j++) {
                modificationCopy[a[j]]++;
                minMax = Math.min(minMax, Math.max(calkMod(modificationCopy), Math.max(prefLMax[i], prefRMax[j])));
            }
        }
//-------------
        maxMax = Math.max(max, calkMod(modificationCopy));
        maxMin = calkMod(modificationCopy);
        if (max != 0) {
            minMax = Math.min(max, minMax);
        }

        return new int[]{minMax, maxMax, minMin, maxMin};
    }

    int calkMod(int[] modification) {
        for (int i = 0; i < modification.length; i++) {
            if (modification[i] == 0) {
                return i;
            }
        }
        return modification.length;
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

    public static void main2(String[] args) throws IOException {
        BinSolution solution = new BinSolution();
        solution.solve();
    }

    public static void main(String[] args) throws IOException {
        BinSolution solution = new BinSolution();
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


        System.out.println(Arrays.toString(solution.calculateAnswer(3, new int[]{0, 6, 0})));
        //[0, 6, 0, 1]
        System.out.println(Arrays.toString(solution.calculateAnswer(2, new int[]{6, 2})));
        //[0, 6, 0, 0]
        System.out.println(Arrays.toString(solution.calculateAnswer(3, new int[]{1, 0, 1})));
        //[1, 2, 0, 2]
    }
}
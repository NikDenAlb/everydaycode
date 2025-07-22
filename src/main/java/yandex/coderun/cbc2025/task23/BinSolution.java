package yandex.coderun.cbc2025.task23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*

           max     max
            |       |
        -   |       |  -
    -       |       |       -   -
-           |       |
            l       r
*/


public class BinSolution {
    int[] calculateAnswer(int n, int[] a) {
        if (n == 1) {
            if (a[0] == 0) {
                a[0] = 1;
            } else {
                a[0] = 0;
            }
            return new int[]{a[0], a[0], a[0], a[0]};
        }
        //[minMax]      [maxMax]                  [minMin]   [maxMin]
        //[mainProblem] [Math.max(max,fullMod)]   [always 0] [fullMod]

        int max = Arrays.stream(a).max().orElseThrow();

        int l = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] == max) {
                l = i;
                break;
            }
        }
        int r = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == max) {
                r = i;
                break;
            }
        }

        int[] modification = new int[max + 1];
        for (int i = l; i <= r; i++) {
            modification[a[i]]++;
        }

        /*

                   max     max
                    |       |
                -   |       |  -
            -       |modBase|       -   -
        -           |   -   |
                    l       r
        */

        int[] prefLMax = new int[n];
        prefLMax[0] = a[0];
        for (int i = 1; i < l; i++) {
            prefLMax[i] = Math.max(prefLMax[i - 1], a[i]);
        }
        int[] prefRMax = new int[n];
        prefRMax[n - 1] = a[n - 1];
        for (int i = n - 2; i > r; i--) {
            prefRMax[i] = Math.max(prefRMax[i + 1], a[i]);
        }

        int leftMax = l > 0 ? prefLMax[l - 1] : 0;
        int rightMax = r < n - 1 ? prefRMax[r + 1] : 0;
        int mod = calkMod(modification);
        int minMax = max == 0 ? 1 : max;
        minMax = Math.min(minMax, Math.max(mod, Math.max(leftMax, rightMax)));

        if (r == n - 1 && l == 0) {
            return new int[]{minMax, Math.max(max, mod), 0, mod};
        }

        if (mod >= minMax) {
            while (l > 0) {
                l--;
                modification[a[l]]++;
            }
            while (r < n - 1) {
                r++;
                modification[a[r]]++;
            }
            mod = calkMod(modification);
            return new int[]{minMax, Math.max(max, mod), 0, mod};
        }

        while (r != n - 1 || l != 0) {
            int nextMax = Math.max(leftMax, rightMax);
            while (l > 0 && prefLMax[l - 1] == nextMax) {
                l--;
                modification[a[l]]++;
            }
            while (r < n - 1 && prefRMax[r + 1] == nextMax) {
                r++;
                modification[a[r]]++;
            }

            leftMax = l > 0 ? prefLMax[l - 1] : 0;
            rightMax = r < n - 1 ? prefRMax[r + 1] : 0;
            mod = calkMod(modification);
            minMax = Math.min(minMax, Math.max(mod, Math.max(leftMax, rightMax)));

            if (mod >= minMax) {
                while (l > 0) {
                    l--;
                    modification[a[l]]++;
                }
                while (r < n - 1) {
                    r++;
                    modification[a[r]]++;
                }
                mod = calkMod(modification);
                return new int[]{minMax, Math.max(max, mod), 0, mod};
            }
        }

        return new int[]{minMax, Math.max(max, mod), 0, mod};
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
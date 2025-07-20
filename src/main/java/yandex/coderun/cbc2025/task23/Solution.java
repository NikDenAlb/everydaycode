package yandex.coderun.cbc2025.task23;

import java.io.*;
import java.util.*;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/danger-core">task link</a><br>
 * test - OK
 */
public class Solution {
    int[] calculateAnswer(int n, int[] a) {
        if (n == 1) {
            int ans = a[0] == 0 ? 1 : 0;
            return new int[]{ans, ans, ans, ans};
        }
        Set<Integer> fullSet = new HashSet<>(Arrays.stream(a).boxed().toList());
        int max = Arrays.stream(a).max().orElseThrow();

        int maxMin = calcMod(fullSet);
        int minMin = 0;
        int maxMax = Math.max(calcMod(fullSet), max);

        int minMax = max == 0 ? 1 : max;
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (a[i] == max) {
                l = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == max) {
                r = i;
                break;
            }
        }

        int[] prefL = new int[n];
        prefL[0] = a[0];
        for (int i = 1; i < l; i++) {
            prefL[i] = Math.max(prefL[i - 1], a[i]);
        }
        int[] prefR = new int[n];
        prefR[n - 1] = a[n - 1];
        for (int i = n - 2; i > r; i--) {
            prefR[i] = Math.max(prefR[i + 1], a[i]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = l; i <= r; i++) {
            set.add(a[i]);
        }
        int mod = calcMod(set);
        int maxL = l == 0 ? 0 : prefL[l - 1];
        int maxR = r == n - 1 ? 0 : prefR[r + 1];
        int maxOut = Math.max(maxL, maxR);
        minMax = Math.min(minMax, Math.max(mod, maxOut));

        while (mod < maxOut && !(l == 0 && r == n - 1)) {
            int nextL = l == 0 ? -1 : prefL[l - 1];
            int nextR = r == n - 1 ? -1 : prefR[r + 1];
            maxOut = Math.max(nextL, nextR);

            while (l > 0 && prefL[l - 1] == maxOut) {
                l--;
                set.add(a[l]);
            }
            while (r < n - 1 && prefR[r + 1] == maxOut) {
                r++;
                set.add(a[r]);
            }
            mod = calcMod(set);
            nextL = l == 0 ? -1 : prefL[l - 1];
            nextR = r == n - 1 ? -1 : prefR[r + 1];
            maxOut = Math.max(nextL, nextR);
            minMax = Math.min(minMax, Math.max(mod, maxOut));
        }

        return new int[]{
                minMax,
                maxMax,
                minMin,
                maxMin
        };
    }

    int calcMod(Set<Integer> set) {
        for (int i = 0; ; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
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
                    for (int value : answer) {
                        out.print(value + " ");
                    }
                    out.println();
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
}
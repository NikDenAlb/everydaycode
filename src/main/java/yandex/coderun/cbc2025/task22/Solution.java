package yandex.coderun.cbc2025.task22;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/ancient-tunnels">task link</a><br>
 * test - OK
 */
public class Solution {
    public int[] calculateAnswer(int n, int[] a) {
        int[] out = new int[n];
        boolean[] dpltd = new boolean[n];
        Arrays.fill(out, 1);
        List<Set<Integer>> sets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            sets.add(new HashSet<>());
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                sets.get(a[i] - 1).add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!dpltd[i] && sets.get(i).isEmpty()) {
                dpltd[i] = true;
                int next = a[i] - 1;
                if (next < 0) {
                    continue;
                }
                sets.get(next).remove(i);
                out[next] += out[i];
                while (!dpltd[next] && sets.get(next).isEmpty()) {
                    dpltd[next] = true;
                    if (a[next] - 1 < 0) {
                        break;
                    }
                    out[a[next] - 1] += out[next];
                    sets.get(a[next] - 1).remove(next);
                    next = a[next] - 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dpltd[i]) {
                continue;
            }
            dpltd[i] = true;
            int sum = out[i];
            int next = a[i] - 1;
            while (!dpltd[next]) {
                sum += out[next];
                dpltd[next] = true;
                next = a[next] - 1;
            }
            out[next] = sum;
            next = a[i] - 1;
            while (out[next] < sum) {
                out[next] = sum;
                next = a[next] - 1;
            }
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

    public static void main2(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.solve();
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.calculateAnswer(1, new int[]{-1})));
        //1
        System.out.println(Arrays.toString(solution.calculateAnswer(2, new int[]{2, 1})));
        //2 2
        System.out.println(Arrays.toString(solution.calculateAnswer(3, new int[]{2, -1, 2})));
        //1 3 1
        System.out.println(Arrays.toString(solution.calculateAnswer(4, new int[]{2, 4, 2, -1})));
        //1 3 1 4
        System.out.println(Arrays.toString(solution.calculateAnswer(5, new int[]{3, 5, -1, 2, 4})));
        //1 3 2 3 3
        System.out.println(Arrays.toString(solution.calculateAnswer(7, new int[]{3, -1, 1, -1, 4, 5, -1})));
        //2 1 2 3 2 1 1
        System.out.println(Arrays.toString(solution.calculateAnswer(3, new int[]{3, 3, 1})));
        //3, 1, 3
        System.out.println(Arrays.toString(solution.calculateAnswer(4, new int[]{2, 1, 1, 3})));
        //4, 4, 2, 1
    }
}
package yandex.coderun.cbc2025.task21;

import java.io.*;
import java.util.*;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/venue">task link</a><br>
 * test - OK
 */
public class Solution {
    class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    Pair calculateAnswer(int n, Point[] points) {
        if (n > 3163) {
            Random rand = new Random();
            int maxPairs = 1_000_000;
            List<Pair> pairs = new ArrayList<>(maxPairs);

            for (int attempt = 0; attempt < maxPairs * 2; attempt++) {
                int i = rand.nextInt(n);
                int j = rand.nextInt(n);
                if (i != j) {
                    pairs.add(new Pair(i, j));
                    if (pairs.size() >= maxPairs) {
                        break;
                    }
                }
            }
            pairs.sort((p1, p2) -> {
                Point a1 = points[p1.first];
                Point b1 = points[p1.second];
                Point a2 = points[p2.first];
                Point b2 = points[p2.second];

                long dx1 = Math.abs((long) b1.x - a1.x);
                long dy1 = Math.abs((long) b1.y - a1.y);
                long dx2 = Math.abs((long) a2.x - a2.x);
                long dy2 = Math.abs((long) b2.y - a2.y);

                if (dx1 == 0 && dx2 == 0) return 0;
                if (dx1 == 0) return 1;
                if (dx2 == 0) return -1;

                return Long.compare(dy1 * dx2, dy2 * dx1);
            });
            for (Pair pair : pairs) {
                Point a = points[pair.first];
                Point b = points[pair.second];
                long midX = a.x + b.x;
                long midY = a.y + b.y;

                long abX = b.x - a.x;
                long abY = b.y - a.y;
                boolean flag = true;
                for (int k = 0; k < points.length; k++) {
                    if (k == pair.first || k == pair.second) {
                        continue;
                    }
                    Point c = points[k];
                    long mcX = 2L * c.x - midX;
                    long mcY = 2L * c.y - midY;
                    if ((abX * mcX + abY * mcY) == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return new Pair(pair.first + 1, pair.second + 1);
                }
            }
            return new Pair(0, 0);
        } else {
            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    pairs.add(new Pair(i, j));
                }
            }

            pairs.sort((p1, p2) -> {
                Point a1 = points[p1.first];
                Point b1 = points[p1.second];
                Point a2 = points[p2.first];
                Point b2 = points[p2.second];

                long dx1 = Math.abs(b1.x - a1.x);
                long dy1 = Math.abs(b1.y - a1.y);
                long dx2 = Math.abs(b2.x - a2.x);
                long dy2 = Math.abs(b2.y - a2.y);

                if (dx1 == 0 && dx2 == 0) return 0;
                if (dx1 == 0) return 1;
                if (dx2 == 0) return -1;

                return Long.compare(dy1 * dx2, dy2 * dx1);
            });

            for (Pair pair : pairs) {
                Point a = points[pair.first];
                Point b = points[pair.second];
                long midX = a.x + b.x;
                long midY = a.y + b.y;

                long abX = b.x - a.x;
                long abY = b.y - a.y;
                boolean flag = true;
                for (int k = 0; k < points.length; k++) {
                    if (k == pair.first || k == pair.second) {
                        continue;
                    }
                    Point c = points[k];
                    long mcX = 2L * c.x - midX;
                    long mcY = 2L * c.y - midY;
                    if ((abX * mcX + abY * mcY) == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return new Pair(pair.first + 1, pair.second + 1);
                }
            }
            return new Pair(0, 0);
        }
    }


    // ввод/вывод
    // не изменяйте сигнатуру метода
    public void solve() throws IOException {
        try (var input = new FastInput(System.in)) {
            try (var out = new PrintWriter(System.out)) {
                int n = input.readInt();
                Point[] points = new Point[n];
                for (int i = 0; i < n; ++i) {
                    int x = input.readInt();
                    int y = input.readInt();
                    points[i] = new Point(x, y);
                }

                Pair answer = calculateAnswer(n, points);
                out.println(answer.first + " " + answer.second);
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
        Solution solution = new Solution();
        solution.solve();
    }
}
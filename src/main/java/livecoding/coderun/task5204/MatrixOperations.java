package livecoding.coderun.task5204;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
int[x][y] m;
x0: [0y1 0y2 0y3 0y4 0y5]
x1: [1y1 1y2 1y3 1y4 1y5]
x2: [2y1 2y2 2y3 2y4 2y5]
x3: [3y1 3y2 3y3 3y4 3y5]
x4: [4y1 4y2 4y3 4y4 4y5]
x5: [5y1 5y2 5y3 5y4 5y5]
*/
/**
 * <a href="https://coderun.yandex.ru/problem/matrix-operations">task link</a><br>
 * <https://youtu.be/sT0ky_U2cQo">video link</a>
 */
public class MatrixOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);

        int[][] a = new int[n][m];
        int[][] b = new int[m][k];

        for (int i = 0; i < n; i++) {
            a[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < m; i++) {
            b[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        writer.write(printM(transpM(multyM(a, b))));

        reader.close();
        writer.close();
    }

    static int[][] multyM(int[][] a, int[][] b) {
        int n = a.length;
        int m = b.length;
        int k = b[0].length;

        int[][] c = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int g = 0; g < m; g++) {
                    c[i][j] += a[i][g] * b[g][j];
                }
            }
        }
        return c;
    }

    static int[][] transpM(int[][] c) {
        int[][] out = new int[c[0].length][c.length];

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                out[j][i] = c[i][j];
            }
        }
        return out;
    }

    static String printM(int[][] m) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                out.append(m[i][j]).append(" ");
            }
            out.setLength(out.length() - 1);
            out.append("\n");
        }
        out.setLength(out.length() - 1);
        return out.toString();
    }
}

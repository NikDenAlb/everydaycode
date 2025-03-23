package livecoding.coderun.task64;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/sapper">task link</a><br>
 * <a href="https://youtu.be/Yf3eXWq_Uwo">video link</a>
 */
public class Sapper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);

        int[][] field = new int[n][m];
        /*

                y-1     y       y+1
        x-1     +       +       +

        x       +       *       +

        x+1     +       +       +

        */
        for (int i = 0; i < k; i++) {
            String[] mine = reader.readLine().split(" ");
            int x = Integer.parseInt(mine[0]) - 1;
            int y = Integer.parseInt(mine[1]) - 1;

            field[x][y] = -9;
            if (x >= 1) {
                if (y >= 1) {
                    field[x - 1][y - 1]++;
                }
                field[x - 1][y]++;
                if (y <= m - 2) {
                    field[x - 1][y + 1]++;
                }
            }
            if (y >= 1) {
                field[x][y - 1]++;
            }
            if (y <= m - 2) {
                field[x][y + 1]++;
            }
            if (x <= n - 2) {
                if (y >= 1) {
                    field[x + 1][y - 1]++;
                }
                field[x + 1][y]++;
                if (y <= m - 2) {
                    field[x + 1][y + 1]++;
                }
            }
        }

        writer.write(printField(field));

        reader.close();
        writer.close();
    }

    static String printField(int[][] field) {
        StringBuilder out = new StringBuilder();
        for (int[] line : field) {
            for (int p : line) {
                if (p < 0) {
                    out.append('*');
                } else {
                    out.append(p);
                }
                out.append(' ');
            }
            out.setCharAt(out.length() - 1, '\n');
        }
        out.setLength(out.length() - 1);

        return out.toString();
    }
}

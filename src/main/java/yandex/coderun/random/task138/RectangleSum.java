package yandex.coderun.random.task138;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class RectangleSum {
    static int[][] ps;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nmk = reader.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);
        int[][] field = new int[n][/*m*/];

        for (int i = 0; i < n; i++) {
            field[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        /*
            [ ][ ][ ][ ][ ][ ][ ][ ]
            [ ][+][ ][ ][ ][-][ ][ ]
            [ ][ ][*][+][+][+][ ][ ]
            [ ][ ][+][+][+][+][ ][ ]
            [ ][ ][+][+][+][+][ ][ ]
            [ ][-][+][+][+][*][ ][ ]
            [ ][ ][ ][ ][ ][ ][ ][ ]
         */
        ps = new int[n][m];

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += field[0][i];
            ps[0][i] = sum;
        }

        for (int i = 1; i < n; i++) {
            sum = 0;
            for (int j = 0; j < m; j++) {
                sum += field[i][j];
                ps[i][j] = ps[i - 1][j] + sum;
            }
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < k; i++) {
            String[] input = reader.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]) - 1;
            int y1 = Integer.parseInt(input[1]) - 1;
            int x2 = Integer.parseInt(input[2]) - 1;
            int y2 = Integer.parseInt(input[3]) - 1;
            out.append(calc(x1, y1, x2, y2)).append("\n");
        }
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static int calc(int x1, int y1, int x2, int y2) {
    /*
            [1][+][+][+][+][+][ ][ ]
            [+][+][+][+][+][+][ ][ ]
            [+][+][+][+][+][+][ ][ ]
            [+][+][+][+][+][+][ ][ ]
            [+][+][+][+][+][+][ ][ ]
            [+][+][+][+][+][2][ ][ ]
            [ ][ ][ ][ ][ ][ ][ ][ ]
    */
        if (x1 == 0 && y1 == 0) {
            return ps[x2][y2];
        }
    /*
            [ ][ ][1][+][+][+][ ][ ]
            [ ][ ][+][+][+][+][ ][ ]
            [ ][ ][+][+][+][+][ ][ ]
            [ ][ ][+][+][+][+][ ][ ]
            [ ][ ][+][+][+][+][ ][ ]
            [ ][ ][+][+][+][2][ ][ ]
            [ ][ ][ ][ ][ ][ ][ ][ ]
    */
        if (x1 == 0) {
            return ps[x2][y2] - ps[x2][y1 - 1];
        }

    /*
            [ ][ ][ ][ ][ ][ ][ ][ ]
            [ ][ ][ ][ ][ ][ ][ ][ ]
            [1][+][+][+][+][+][ ][ ]
            [+][+][+][+][+][+][ ][ ]
            [+][+][+][+][+][+][ ][ ]
            [+][+][+][+][+][2][ ][ ]
            [ ][ ][ ][ ][ ][ ][ ][ ]
    */
        if (y1 == 0) {
            return ps[x2][y2] - ps[x1 - 1][y2];
        }

    /*
            [+][+][-][-][-][-][ ][ ]
            [+][+][-][-][-][-][ ][ ]
            [-][-][1][+][+][+][ ][ ]
            [-][-][+][+][+][+][ ][ ]
            [-][-][+][+][+][+][ ][ ]
            [-][-][+][+][+][2][ ][ ]
            [ ][ ][ ][ ][ ][ ][ ][ ]
    */
        return ps[x2][y2] + ps[x1 - 1][y1 - 1] - ps[x1 - 1][y2] - ps[x2][y1 - 1];
    }
}

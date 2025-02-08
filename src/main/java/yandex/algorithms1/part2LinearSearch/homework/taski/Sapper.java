package yandex.algorithms1.part2LinearSearch.homework.taski;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * test - OK
 */
public class Sapper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] field = reader.readLine().split(" ");
        int n = Integer.parseInt(field[0]);
        int m = Integer.parseInt(field[1]);
        int k = Integer.parseInt(field[2]);
        int[][] matrix = new int[n][m];
        for (int i = 0; i < k; i++) {
            String[] mine = reader.readLine().split(" ");
            int p = Integer.parseInt(mine[0]);
            int q = Integer.parseInt(mine[1]);
            matrix[p - 1][q - 1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != -1) {
                    int count = 0;
                    for (int i1 = -1; i1 < 2; i1++) {
                        for (int j1 = -1; j1 < 2; j1++) {
                            int x = i + i1;
                            int y = j + j1;
                            if (x >= 0 && x < n && y >= 0 && y < m) {
                                if (matrix[x][y] == -1) {
                                    count++;
                                }
                            }
                        }
                    }
                    matrix[i][j] = count;
                }
            }
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < m; i1++) {
                if (matrix[i][i1] == -1) {
                    out.append('*').append(" ");
                } else out.append(matrix[i][i1]).append(" ");
            }
            out.append("\n");
        }
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

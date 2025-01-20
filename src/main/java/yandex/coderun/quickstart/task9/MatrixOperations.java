package yandex.coderun.quickstart.task9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/matrix-operations">task link</a><br>
 * test - OK
 */
public class MatrixOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int[][] mA = new int[n][m];
        for (int i = 0; i < n; i++) {
            mA[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] mB = new int[m][k];
        for (int i = 0; i < m; i++) {
            mB[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] mC = new int[n][k];
        for (int im = 0; im < m; im++) {
            for (int in = 0; in < n; in++) {
                for (int ik = 0; ik < k; ik++) {
                    mC[in][ik] += mA[in][im] * mB[im][ik];
                }
            }
        }
        int[][] mCT = new int[k][n];
        for (int ik = 0; ik < k; ik++) {
            for (int in = 0; in < n; in++) {
                mCT[ik][in] = mC[in][ik];
            }
        }
        StringBuilder out = new StringBuilder();
        for (int ik = 0; ik < k - 1; ik++) {
            for (int in = 0; in < n - 1; in++) {
                out.append(mCT[ik][in]).append(" ");
            }
            out.append(mCT[ik][n - 1]).append("\n");
        }
        for (int in = 0; in < n - 1; in++) {
            out.append(mCT[k - 1][in]).append(" ");
        }
        out.append(mCT[k - 1][n - 1]);

        writer.write(out.toString());


        reader.close();
        writer.close();
    }
}

package yandex.coderun.hrtechinterview.task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/selections/hr-tech-interview/problems/tourism">task link</a><br>
 * test - OK
 */
public class Tourism {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] stsY = new int[n];
        for (int i = 0; i < n; i++) {
            stsY[i] = Integer.parseInt(reader.readLine().split(" ")[1]);
        }
        int[] prefixR = new int[n], prefixL = new int[n];
        prefixR[0] = 0;
        prefixL[n - 1] = 0;
        for (int i = 1; i < prefixR.length; i++) {
            prefixR[i] = Math.max(stsY[i] - stsY[i - 1], 0) + prefixR[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            prefixL[i] = Math.max(stsY[i] - stsY[i + 1], 0) + prefixL[i + 1];
        }

        int m = Integer.parseInt(reader.readLine());
        int[][] stsAB = new int[m][2];
        for (int i = 0; i < m; i++) {
            stsAB[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < m - 1; i++) {
            output.append(calcRise(prefixL, prefixR, stsAB[i][0], stsAB[i][1])).append('\n');
        }
        output.append(calcRise(prefixL, prefixR, stsAB[m - 1][0], stsAB[m - 1][1]));

        writer.write(output.toString());

        reader.close();
        writer.close();
    }

    static int calcRise(int[] prefixL, int[] prefixR, int a, int b) {
        if (a == b) return 0;
        if (b > a) {
            return prefixR[b-1]-prefixR[a-1];
        }
        return prefixL[b-1]-prefixL[a-1];
    }
}

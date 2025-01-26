package yandex.coderun.hrtechinterview.task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/selections/hr-tech-interview/problems/tourism">task link</a><br>
 * test 27 - TL
 */
public class TourismBetterTL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] stationsY = new int[n];
        for (int i = 0; i < stationsY.length; i++) {
            stationsY[i] = Integer.parseInt(reader.readLine().split(" ")[1]);
        }
        int[] stationsRise = new int[n - 1];
        for (int i = 0; i < stationsRise.length; i++) {
            stationsRise[i] = Math.max(stationsY[i + 1] - stationsY[i], 0);
        }
        int[] stationsRiseB = new int[n - 1];
        for (int i = stationsRiseB.length - 1; i >= 0; i--) {
            stationsRiseB[i] = Math.max(stationsY[i] - stationsY[i + 1], 0);
        }

        int m = Integer.parseInt(reader.readLine());
        int[][] stationsAB = new int[m][2];
        for (int i = 0; i < stationsAB.length; i++) {
            stationsAB[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < m - 1; i++) {
            output.append(calcRise(stationsRise, stationsRiseB, stationsAB[i][0], stationsAB[i][1])).append('\n');
        }
        output.append(calcRise(stationsRise, stationsRiseB, stationsAB[m - 1][0], stationsAB[m - 1][1]));

        writer.write(output.toString());

        reader.close();
        writer.close();
    }

    static int calcRise(int[] stationsRise, int[] stationsRiseB, int a, int b) {
        int out = 0;
        if (a == b) return 0;
        a--;
        b--;
        int steps = Math.abs(a - b);
        int step = a < b ? 1 : -1;
        int[] stationsMove = a < b ? stationsRise : stationsRiseB;
        if (a > b) {
            a--;
        }
        for (int i = 0; i < steps; i++) {
            out += stationsMove[a];
            a += step;
        }
        return out;
    }
}

package yandex.coderun.hrtechinterview.task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/selections/hr-tech-interview/problems/tourism">task link</a><br>
 * test 22 - TL
 */
public class TourismTimeLimit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] stationsCoord = new int[n];
        for (int i = 0; i < stationsCoord.length; i++) {
            stationsCoord[i] = Integer.parseInt(reader.readLine().split(" ")[1]);
        }
        int m = Integer.parseInt(reader.readLine());
        int[][] stationsAB = new int[m][];
        for (int i = 0; i < stationsAB.length; i++) {
            stationsAB[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < m - 1; i++) {
            output.append(calcRise(stationsCoord, stationsAB[i][0], stationsAB[i][1])).append('\n');
        }
        output.append(calcRise(stationsCoord, stationsAB[m - 1][0], stationsAB[m - 1][1]));

        writer.write(output.toString());

        reader.close();
        writer.close();
    }

    static int calcRise(int[] stationsCoord, int a, int b) {
        int out = 0;
        if (a == b) return 0;
        int step = a < b ? 1 : -1;
        do {
            if (stationsCoord[a + step - 1] > stationsCoord[a - 1]) {
                out += stationsCoord[a + step - 1] - stationsCoord[a - 1];
            }
            a += step;
        } while (a != b);
        return out;
    }
}

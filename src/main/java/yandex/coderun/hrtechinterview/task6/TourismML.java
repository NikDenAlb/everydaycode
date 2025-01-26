package yandex.coderun.hrtechinterview.task6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/selections/hr-tech-interview/problems/tourism">task link</a><br>
 * test 10 - ML
 */
public class TourismML {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] stsY = new int[n];
        for (int i = 0; i < n; i++) {
            stsY[i] = Integer.parseInt(reader.readLine().split(" ")[1]);
        }

        HashMap<Integer, Map<Integer, Integer>> mapR = new HashMap<>();
        HashMap<Integer, Map<Integer, Integer>> mapL = new HashMap<>();

        for (int i = 1; i < n; i++) {
            int diffR = 0;
            HashMap<Integer, Integer> innerMapR = new HashMap<>();
            for (int j = i + 1; j <= n; j++) {
                diffR += Math.max(stsY[j-1] - stsY[j - 2], 0);
                innerMapR.put(j, diffR);
            }
            mapR.put(i, innerMapR);
        }

        for (int i = n; i >= 2; i--) {
            int diffL = 0;
            HashMap<Integer, Integer> innerMapL = new HashMap<>();
            for (int j = i - 1; j >= 1; j--) {
                diffL += Math.max(stsY[j - 1] - stsY[j], 0);
                innerMapL.put(j, diffL);
            }
            mapL.put(i, innerMapL);
        }

        int m = Integer.parseInt(reader.readLine());
        int[][] stsAB = new int[m][2];
        for (int i = 0; i < m; i++) {
            stsAB[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < m - 1; i++) {
            output.append(calcRise(mapR, mapL, stsAB[i][0], stsAB[i][1])).append('\n');
        }
        output.append(calcRise(mapR, mapL, stsAB[m - 1][0], stsAB[m - 1][1]));

        writer.write(output.toString());

        reader.close();
        writer.close();
    }

    static int calcRise(Map<Integer, Map<Integer, Integer>> mapR, Map<Integer, Map<Integer, Integer>> mapL, int a, int b) {
        if (a == b) return 0;
        if (b > a) {
            return mapR.get(a).get(b);
        }
        return mapL.get(a).get(b);
    }
}

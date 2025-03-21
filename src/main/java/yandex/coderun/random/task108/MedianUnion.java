package yandex.coderun.random.task108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/median-union">task link</a><br>
 * test - OK
 */
public class MedianUnion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine().split(" ")[0]);
        int[][] input = new int[n][];
        for (int i = 0; i < n; i++) {
            input[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                out.append(findMedianUnion(input[i], input[j])).append('\n');
            }
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static int findMedianUnion(int[] a, int[] b) {
        int iA = 0, iB = 0;
        while (iA + iB < a.length - 1) {
            if (a[iA] <= b[iB]) {
                iA++;
            } else {
                iB++;
            }
        }
        return Math.min(a[iA], b[iB]);
    }
}

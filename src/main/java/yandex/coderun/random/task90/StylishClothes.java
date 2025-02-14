package yandex.coderun.random.task90;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/stylish-clothes">task link</a><br>
 * test - OK
 */
public class StylishClothes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();
        int[] n = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        reader.readLine();
        int[] m = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(findClosestValues(n, m));

        reader.close();
        writer.close();
    }

    static String findClosestValues(int[] n, int[] m) {
        int i = 0, j = 0;

        if (n[0] >= m[m.length - 1]) {
            j = m.length - 1;
            return n[i] + " " + m[j];
        }

        if (m[0] >= n[n.length - 1]) {
            i = n.length - 1;
            return n[i] + " " + m[j];
        }

        int d = Integer.MAX_VALUE;
        int mI = 0, mJ = 0;

        while (i < n.length && j < m.length) {
            if (n[i] < m[j]) {
                if (m[j] - n[i] < d) {
                    d = m[j] - n[i];
                    mI = i;
                    mJ = j;
                }
                i++;
            } else if (n[i] == m[j]) {
                return n[i] + " " + m[j];
            } else {
                if (n[i] - m[j] < d) {
                    d = n[i] - m[j];
                    mI = i;
                    mJ = j;
                }
                j++;
            }
        }
        return n[mI] + " " + m[mJ];
    }
}

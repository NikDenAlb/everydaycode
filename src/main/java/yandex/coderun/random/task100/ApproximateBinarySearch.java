package yandex.coderun.random.task100;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/bpproximate-binary-search">task link</a><br>
 * test - OK
 */
public class ApproximateBinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();
        int[] n = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] k = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder out = new StringBuilder();

        for (int e : k) {
            out.append(approximateBinarySearch(e, n)).append('\n');
        }
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static int approximateBinarySearch(int e, int[] arr) {
        int l = 0, r = arr.length - 1;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (arr[m] < e) {
                l = m;
            } else {
                r = m;
            }
        }
        return e - arr[l] <= arr[r] - e ? arr[l] : arr[r];
    }
}

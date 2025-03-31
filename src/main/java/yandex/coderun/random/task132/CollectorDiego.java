package yandex.coderun.random.task132;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/collector-diego">task link</a><br>
 * test - OK
 */
public class CollectorDiego {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); //number of Diego stickers
        int[] stD = Arrays.stream(reader.readLine().split(" ")).distinct().mapToInt(Integer::parseInt).sorted().toArray();
        reader.readLine(); //number of guests
        int[] p = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder out = new StringBuilder();
        for (int e : p) {
            out.append(calcLowerNums(stD, e)).append("\n");
        }
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static int calcLowerNums(int[] nums, int maxN) {
        if (nums[0] >= maxN) {
            return 0;
        }
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= maxN) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r == 0 ? 1 : r;
    }
}

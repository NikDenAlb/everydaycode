package livecoding.coderun.task70;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/nearest-number">task link</a><br>
 * <a href="https://youtu.be/y0lRm9saqVM">video link</a>
 */
public class NearestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(reader.readLine());

        int d = 2001, out = 1001;

        for (int num : nums) {
            if (Math.abs(num - x) < d) {
                d = Math.abs(num - x);
                out = num;
            }
        }

        writer.write(String.valueOf(out));

        reader.close();
        writer.close();
    }
}

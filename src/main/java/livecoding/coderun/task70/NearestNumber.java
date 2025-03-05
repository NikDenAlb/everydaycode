package livecoding.coderun.task70;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/nearest-number">task link</a><br>
 * <https://youtu.be/y0lRm9saqVM">video link</a>
 */
public class NearestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(reader.readLine());

        int d = 2001, out = 1001;

        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - x) < d) {
                d = Math.abs(nums[i] - x);
                out = nums[i];
            }
        }

        writer.write(String.valueOf(out));

        reader.close();
        writer.close();
    }
}

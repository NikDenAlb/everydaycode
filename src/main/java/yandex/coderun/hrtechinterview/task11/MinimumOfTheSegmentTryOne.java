package yandex.coderun.hrtechinterview.task11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/selections/hr-tech-interview/problems/minimum-of-the-segment">task link</a><br>
 * test 11 - TL
 */
public class MinimumOfTheSegmentTryOne {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = reader.readLine().split(" ");
        int k = Integer.parseInt(nk[1]);

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int minV = Integer.MAX_VALUE;
        int minI = -1;
        for (int i = 0; i < k; i++) {
            if (minV >= nums[i]) {
                minV = nums[i];
                minI = i;
            }
        }
        writer.write(String.valueOf(minV));
        for (int i = k; i < nums.length; i++) {
            if (i - minI < k) {
                if (minV >= nums[i]) {
                    minV = nums[i];
                    minI = i;
                    writer.newLine();
                    writer.write(String.valueOf(minV));
                    continue;
                }
                writer.newLine();
                writer.write(String.valueOf(minV));
                continue;
            }
            minV = nums[++minI];
            int recMinI = minI;
            for (int j = minI + 1; j < recMinI + k && j < nums.length; j++) {
                if (minV >= nums[j]) {
                    minV = nums[j];
                    minI = j;
                }
            }
            writer.newLine();
            writer.write(String.valueOf(minV));
        }
        reader.close();
        writer.close();
    }
}

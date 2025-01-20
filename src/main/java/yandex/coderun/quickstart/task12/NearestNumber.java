package yandex.coderun.quickstart.task12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/nearest-number">task link</a><br>
 * test - OK
 */
public class NearestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(reader.readLine());
        String[] stringNums = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(stringNums[i]);
        }
        int x = Integer.parseInt(reader.readLine());

        int d = Math.abs(x - nums[0]);
        int out = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(x - nums[i]) < d) {
                out = nums[i];
                d = Math.abs(x - nums[i]);
            }
        }

        writer.write(String.valueOf(out));

        reader.close();
        writer.close();
    }
}

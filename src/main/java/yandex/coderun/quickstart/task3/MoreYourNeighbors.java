package yandex.coderun.quickstart.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/more-your-neighbors/">task link</a><br>
 * test - OK
 */
public class MoreYourNeighbors {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (nums[i] > nums[i - 1]) {
                    count++;
                }
                i++;
            }
        }
        writer.write(String.valueOf(count));


        reader.close();
        writer.close();
    }
}

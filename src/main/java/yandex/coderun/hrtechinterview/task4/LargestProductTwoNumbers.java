package yandex.coderun.hrtechinterview.task4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/selections/hr-tech-interview/problems/largest-product-two-numbers">task link</a><br>
 * test - OK 
 */
public class LargestProductTwoNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int x1, x2;

        if (nums.length > 3) {

            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

            for (int num : nums) {
                if (num >= max1) {
                    max2 = max1;
                    max1 = num;
                } else if (num >= max2) {
                    max2 = num;
                }
                if (num <= min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num <= min2) {
                    min2 = num;
                }
            }

            if ((long) min1 * min2 > (long) max1 * max2) {
                x1 = min1;
                x2 = min2;
            } else {
                x1 = max2;
                x2 = max1;
            }
        } else if (nums.length == 3) {
            Arrays.sort(nums);
            if ((long) nums[0] * nums[1] > (long) nums[1] * nums[2]) {
                x1 = nums[0];
                x2 = nums[1];
            } else {
                x1 = nums[1];
                x2 = nums[2];
            }
        } else {
            x1 = Math.min(nums[0], nums[1]);
            x2 = Math.max(nums[0], nums[1]);
        }

        writer.write(x1 + " " + x2);

        reader.close();
        writer.close();
    }
}

package yandex.algorithms1.part2LinearSearch.homework.taskh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * test - OK
 */
public class LargestProductThreeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] out;
        if (nums.length > 5) {
            Arrays.sort(nums);
            int[] newNums;
            newNums = new int[5];
            newNums[4] = nums[nums.length - 1];
            newNums[3] = nums[nums.length - 2];
            newNums[2] = nums[nums.length - 3];
            newNums[1] = nums[1];
            newNums[0] = nums[0];
            out = largestProductThreeNumbers(newNums);
        } else {
            out = largestProductThreeNumbers(nums);
        }
        writer.write(out[0] + " " + out[1] + " " + out[2]);

        reader.close();
        writer.close();
    }

    static int[] largestProductThreeNumbers(int[] nums) {
        int[] out = new int[3];
        long max = Long.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int i1 = i + 1; i1 < nums.length - 1; i1++) {
                for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                    long result = (long) nums[i] * nums[i1] * nums[i2];
                    if (result > max) {
                        max = result;
                        out[0] = nums[i];
                        out[1] = nums[i1];
                        out[2] = nums[i2];
                    }
                }
            }
        }
        return out;
    }
}

package yandex.coderun.hrtechinterview.task7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/selections/hr-tech-interview/problems/sum-of-numbers">task link</a><br>
 * test - OK
 */
public class SumOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numsNK = reader.readLine().split(" ");
        long k = Long.parseLong(numsNK[1]);
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(String.valueOf(countVariantsOfSum(k, nums)));

        reader.close();
        writer.close();
    }

    static int countVariantsOfSum(long goal, int[] nums) {
        int l = 0, r = 0, sum = nums[0], count = 0;

        while (r < nums.length - 1) {
            if (sum == goal) {
                count++;
                sum -= nums[l++];
                sum += nums[++r];
            } else if (sum < goal) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
                if (l > r) {
                    sum += nums[++r];
                }
            }
        }
        while (sum >= goal && l <= r) {
            if (sum == goal) {
                return ++count;
            }
            sum -= nums[l++];
        }
        return count;
    }

    /**
     * test 12 - WA
     * don't see what is wrong on it. I did a break and wrote correct method from zero. TODO find problem
     */
    static int countVariantsOfSumBad(long sumGoal, int[] nums) {
        int count = 0;
        int r = 0, l = 0;
        long sum = nums[0];
        while (r < nums.length - 1) {
            if (sum == sumGoal) {
                count++;
                sum += nums[++r];
                sum -= nums[l++];
            } else if (sum > sumGoal) {
                sum -= nums[l++];
                if (l > r) {
                    sum += nums[++r];
                }
            } else {
                sum += nums[++r];
            }
        }
        if (sum == sumGoal) {
            return ++count;
        } else if (sum > sumGoal) {
            while (l > r) {
                sum -= nums[l++];
                if (sum == sumGoal) {
                    return ++count;
                }
                if (sum < sumGoal) {
                    return count;
                }
            }
        }
        return count;
    }
}

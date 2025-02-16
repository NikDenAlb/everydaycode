package yandex.coderun.random.task68;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/cup-cowcake-throwing">task link</a><br>
 * test - OK
 */
public class CupCowCakeThrowing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        writer.write(String.valueOf(defineHighestPlace(nums)));

        reader.close();
        writer.close();
    }

    static int defineHighestPlace(int[] nums) {
        int dist = 0, count = 0, winnerInd = -1;
        int winnerDist = Arrays.stream(nums).max().getAsInt();

        for (int i = 0; i < nums.length; i++) {
            if (winnerDist == nums[i]) {
                winnerInd = i;
                break;
            }
        }

        for (int i = winnerInd + 1; i < nums.length - 1; i++) {
            if (nums[i] % 5 == 0 && nums[i] / 5 % 2 == 1 && nums[i + 1] < nums[i]) {
                if (dist < nums[i]) {
                    dist = nums[i];
                }
            }
        }

        if (dist == 0) {
            return 0;
        }

        for (int num : nums) {
            if (num > dist) {
                count++;
            }
        }

        return ++count;
    }
}

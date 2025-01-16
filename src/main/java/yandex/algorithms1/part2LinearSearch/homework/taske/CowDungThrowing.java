package yandex.algorithms1.part2LinearSearch.homework.taske;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * test - OK:   287ms   26.04Mb
 */
public class CowDungThrowing {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        reader.close();

        System.out.println(defineHighestPlace(nums));
    }

    /**
     * @return самое высокое из возможных мест. Если условия некорректны - 0.
     */
    public static int defineHighestPlace(int[] nums) {
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

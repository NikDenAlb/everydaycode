package yandex.algorithms1.part2LinearSearch.homework.taskc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * test - OK: 55ms  10.57Mb
 */
public class ClosestNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] nums = new int[n];
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int x = Integer.parseInt(reader.readLine());

        reader.close();

        System.out.println(findClosestNumber(nums, x));
    }

    /**
     * @param nums последовательность чисел
     * @param x    число, по которому идёт поиск
     * @return какое-либо ближайшее к x число из последовательности
     */
    public static int findClosestNumber(int[] nums, int x) {
        int currD = Integer.MAX_VALUE;
        int out = Integer.MIN_VALUE;

        for (int num : nums) {
            int newD = Math.abs(num - x);
            if (newD < currD) {
                out = num;
                currD = newD;
            }
        }

        return out;
    }
}

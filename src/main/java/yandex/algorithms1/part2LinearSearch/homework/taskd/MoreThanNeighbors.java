package yandex.algorithms1.part2LinearSearch.homework.taskd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * test - OK: 149ms 16.23Mb
 */
public class MoreThanNeighbors {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        reader.close();

        System.out.println(countMoreThanNeighbors(nums));
    }

    /**
     * @return количество элементов последовательности, которые больше двух своих соседей
     */
    public static int countMoreThanNeighbors(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (nums[i] > nums[i - 1]) {
                    count++;
                }
                i++;
            }
        }
        return count;
    }
}

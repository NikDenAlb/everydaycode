package yandex.coderun.random.task143;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://coderun.yandex.ru/problem/sorting-of-wagons-lite">task link</a><br>
 * test - OK
 */
public class SortingOfWagonsLite {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int minActive = Integer.MIN_VALUE;
        List<Integer> mins = new ArrayList<>(List.of(nums[0]));

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minActive) {
                writer.write("NO");
                reader.close();
                writer.close();
                return;
            }
            int index = findInsertIndex(mins, nums[i]);
            if (index == 0) {
                mins.addFirst(nums[i]);
            } else {
                minActive = Math.max(minActive, mins.get(index - 1));
                mins.add(index, nums[i]);
            }
        }
        writer.write("YES");

        reader.close();
        writer.close();
    }

    static int findInsertIndex(List<Integer> sortedList, int number) {
        int l = 0;
        for (int r = sortedList.size() - 1; l <= r; ) {
            int mid = l + (r - l) / 2;
            if (sortedList.get(mid) < number) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}

package yandex.coderun.random.task167;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://coderun.yandex.ru/problem/product-equal-k">task link</a><br>
 * test - OK
 */
public class ProductEqualK {
    static int k;
    static List<Integer> path = new ArrayList<>();
    static int[] nums;
    static int[] sortNums;
    static int strt;
    static int ones = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sortNums = IntStream.range(0, nums.length)
                .boxed()
                .sorted(Comparator.comparingInt(i -> nums[i]))
                .mapToInt(Integer::intValue)
                .toArray();

        if (m == 0) {
            writer.write(String.valueOf(sortNums[0] + 1));
            for (int i = 1; i < k; i++) {
                writer.write(" " + (sortNums[i] + 1));
            }
            reader.close();
            writer.close();
            return;
        }

        while (nums[sortNums[ones]] == 0) {
            ones++;
        }
        strt = ones;
        while (nums[sortNums[strt]] == 1) {
            strt++;
        }
        ones = strt - ones;

        dfs(strt, m);
        if (path.size() < k) {
            for (int i = 0, end = k - path.size(); i < end; i++) {
                path.add(sortNums[strt - i - 1] + 1);
            }
        }

        writer.write(path.stream().map(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }

    static boolean dfs(int pos, long trgt) {
        if (path.size() == k) {
            return trgt == 1;
        }
        if (trgt == 1) {
            int addOnes = k - path.size();
            return addOnes >= 0 && addOnes <= ones;
        }
        for (int i = pos; i < sortNums.length; i++) {
            int val = nums[sortNums[i]];
            if (trgt % val == 0) {
                path.add(sortNums[i] + 1);
                if (dfs(i + 1, trgt / val)) {
                    return true;
                }
                path.removeLast();
            }
        }
        return false;
    }
}
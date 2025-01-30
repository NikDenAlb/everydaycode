package yandex.coderun.hrtechinterview.task11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://coderun.yandex.ru/selections/hr-tech-interview/problems/minimum-of-the-segment">task link</a><br>
 * test 5 - TL
 */
public class MinimumOfTheSegmentBrute {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = reader.readLine().split(" ");
        int k = Integer.parseInt(nk[1]);
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            stack.push(nums[i]);
        }
        writer.write(String.valueOf(stack.stream().min(Integer::compareTo).get()));
        for (int i = k; i < nums.length; i++) {
            stack.removeLast();
            stack.push(nums[i]);
            writer.newLine();
            writer.write(String.valueOf(stack.stream().min(Integer::compareTo).get()));
        }

        reader.close();
        writer.close();
    }
}

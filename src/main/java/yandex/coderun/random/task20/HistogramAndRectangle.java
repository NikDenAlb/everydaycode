package yandex.coderun.random.task20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <a href="https://coderun.yandex.ru/problem/histogram-and-rectangle">task link</a><br>
 * test - OK
 */
class HistogramAndRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> stack = new ArrayDeque<>();
        long mS = 0;

        for (int i = 1; i <= nums[0]; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int p = stack.pop();
                int l = stack.isEmpty() ? 0 : stack.peek();
                long s = (long) nums[p] * (i - 1 - l);
                if (s > mS) {
                    mS = s;
                }
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int l = stack.isEmpty() ? 0 : stack.peek();
            long s = (long) nums[p] * (nums[0] - l);
            if (s > mS) {
                mS = s;
            }
        }

        writer.write(String.valueOf(mS));

        reader.close();
        writer.close();
    }
}

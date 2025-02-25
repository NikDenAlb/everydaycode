package yandex.coderun.random.task58;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://coderun.yandex.ru/problem/open-calculator">task link</a><br>
 * test - OK
 */
public class OpenCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> nums = new HashSet<>(Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toList());

        int n = Integer.parseInt(reader.readLine());

        do {
            nums.add(n % 10);
            n /= 10;
        } while (n != 0);

        writer.write(String.valueOf(nums.size() - 3));

        reader.close();
        writer.close();
    }
}

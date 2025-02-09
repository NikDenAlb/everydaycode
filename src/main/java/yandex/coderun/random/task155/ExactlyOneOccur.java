package yandex.coderun.random.task155;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://coderun.yandex.ru/problem/exactly-one-occur">task link</a><br>
 * test - OK
 */
public class ExactlyOneOccur {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();
        List<Integer> nums = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).toList();

        Set<Integer> ones = new HashSet<>();
        Set<Integer> twice = new HashSet<>();

        nums.forEach(e -> {
            if (ones.contains(e)) {
                twice.add(e);
            } else {
                ones.add(e);
            }
        });
        ones.removeAll(twice);
        writer.write(String.valueOf(ones.size()));

        reader.close();
        writer.close();
    }
}

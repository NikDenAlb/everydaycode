package yandex.coderun.random.task144;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/great-lineland-migration">task link</a><br>
 * test - OK
 */
public class GreatLineLandMigration {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); //N
        int[] n = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] out = new int[n.length];
        Arrays.fill(out, -1);

        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < n.length; i++) {
            while (!stack.isEmpty() && n[i] < n[stack.getLast()]) {
                int index = stack.removeLast();
                out[index] = i;
            }
            stack.add(i);
        }

        writer.write(Arrays.stream(out).boxed().map(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}

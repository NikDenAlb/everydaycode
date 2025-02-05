package yandex.coderun.random.task61;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/intersection-sets">task link</a><br>
 * test - OK
 */
public class IntersectionSets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> setA = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toSet());
        Set<Integer> setB = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toSet());
        setA.retainAll(setB);
        StringBuilder out = new StringBuilder();
        setA.stream()
                .sorted()
                .forEach(e -> out.append(e).append(" "));
        out.setLength(out.length() - 1);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

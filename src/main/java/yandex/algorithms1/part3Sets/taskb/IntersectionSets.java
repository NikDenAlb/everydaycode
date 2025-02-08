package yandex.algorithms1.part3Sets.taskb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * test - OK
 */
public class IntersectionSets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

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

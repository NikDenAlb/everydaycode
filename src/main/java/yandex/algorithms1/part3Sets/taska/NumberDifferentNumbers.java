package yandex.algorithms1.part3Sets.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * test - OK
 */
public class NumberDifferentNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(String.valueOf(Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toSet()).size()));

        reader.close();
        writer.close();
    }
}

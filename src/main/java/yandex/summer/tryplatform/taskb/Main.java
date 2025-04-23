package yandex.summer.tryplatform.taskb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        long[] ab = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        writer.write(String.valueOf(ab[0] + ab[1]));

        reader.close();
        writer.close();
    }
}

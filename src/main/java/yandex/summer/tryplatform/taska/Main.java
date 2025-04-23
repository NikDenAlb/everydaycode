package yandex.summer.tryplatform.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ab = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(String.valueOf(ab[0] + ab[1]));

        reader.close();
        writer.close();
    }
}

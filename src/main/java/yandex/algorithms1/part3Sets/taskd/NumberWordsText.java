package yandex.algorithms1.part3Sets.taskd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * test - OK
 */
public class NumberWordsText {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            set.addAll(Arrays.asList(line.split(" ")));
        }
        writer.write(String.valueOf(set.size()));

        reader.close();
        writer.close();
    }
}

package yandex.coderun.random.task543;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://coderun.yandex.ru/problem/triangle-similarity">task link</a><br>
 * test - TL
 */
public class TriangleSimilarityTL {
    static List<List<Long>> classes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            addToClasses(Arrays.stream(reader.readLine().split(" ")).map(Long::parseLong).sorted().toList());
        }

        writer.write(String.valueOf(classes.size()));

        reader.close();
        writer.close();
    }

    static void addToClasses(List<Long> abc) {
        for (List<Long> aClass : classes) {
            if (    aClass.get(0) * abc.get(1) == aClass.get(1) * abc.get(0) &&
                    aClass.get(0) * abc.get(2) == aClass.get(2) * abc.get(0)) {
                return;
            }
        }
        classes.add(abc);
    }
}

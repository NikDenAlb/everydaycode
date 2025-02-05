package yandex.coderun.random.task57;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://coderun.yandex.ru/problem/alien-genome">task link</a><br>
 * test - OK
 */
public class AlienGenome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String genA = reader.readLine();
        String genB = reader.readLine();

        List<String> genAList = new ArrayList<>();
        Set<String> genBSet = new HashSet<>();

        for (int i = 0; i < genA.length() - 1; i++) {
            genAList.add(genA.substring(i, i + 2));
        }
        for (int i = 0; i < genB.length() - 1; i++) {
            genBSet.add(genB.substring(i, i + 2));
        }

        writer.write(String.valueOf(genAList.stream().filter(genBSet::contains).count()));

        reader.close();
        writer.close();
    }
}

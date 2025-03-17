package yandex.coderun.random.task352;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/rocks-and-jewels">task link</a><br>
 * test - OK
 */
public class RocksAndJewels {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String j = reader.readLine();
        String s = reader.readLine();

        Set<Integer> jSet = j.chars().boxed().collect(Collectors.toSet());
        writer.write(String.valueOf(s.chars().filter(jSet::contains).count()));

        reader.close();
        writer.close();
    }
}

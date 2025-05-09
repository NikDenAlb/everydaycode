package yandex.coderun.random.task34;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/space-scavenger">task link</a><br>
 * test - ML
 */
public class SpaceScavengerML {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Character, List<Character>> map = new HashMap<>();

        map.put('N', reader.readLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        map.put('S', reader.readLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        map.put('W', reader.readLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        map.put('E', reader.readLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        map.put('U', reader.readLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        map.put('D', reader.readLine().chars().mapToObj(c -> (char) c).collect(Collectors.toList()));

        String[] cmd = reader.readLine().split(" ");
        List<Character> step = new ArrayList<>(List.of(cmd[0].charAt(0)));

        int out = 0;
        for (int count = Integer.parseInt(cmd[1]); count > 0; count--) {
            out += step.size();
            step = step.stream().map(map::get).flatMap(List::stream).toList();
        }

        writer.write(String.valueOf(out));

        reader.close();
        writer.close();
    }
}

package yandex.coderun.random.task130;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/histogram">task link</a><br>
 * test 3 - WA TODO
 */
public class Histogram {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Character, Integer> map = new HashMap<>();
        String input;
        while ((input = reader.readLine()) != null && !input.isEmpty()) {
            char[] chars = input.replaceAll(" ","").toCharArray();
            for (char ch : chars) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        List<Integer> nums = new ArrayList<>(map.size());
        StringBuilder out = new StringBuilder();
        StringBuilder outNext = new StringBuilder();
        map.keySet().stream().sorted()
                .forEach(e -> {
                    outNext.append(e);
                    nums.add(map.get(e));
                });

        int peak = nums.stream().max(Integer::compareTo).orElse(0);

        for (int i = peak; i > 0; i--) {
            for (Integer num : nums) {
                out.append(num >= i ? "#" : " ");
            }
            out.append("\n");
        }
        out.append(outNext);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

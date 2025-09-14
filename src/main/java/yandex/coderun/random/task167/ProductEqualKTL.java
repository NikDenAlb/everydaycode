package yandex.coderun.random.task167;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/product-equal-k">task link</a><br>
 * test - TL
 */
class ProductEqualKTL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        long m = Long.parseLong(input[1]);
        int k = Integer.parseInt(input[2]) - 1;
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Map<Long, List<Integer>>> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new HashMap<>());
        }

        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == m) {
                    writer.write(String.valueOf(i + 1));
                    reader.close();
                    writer.close();
                    return;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (Map.Entry<Long, List<Integer>> entry : list.get(k - 1).entrySet()) {
                if (entry.getKey() * nums[i] == m) {
                    entry.getValue().add(i + 1);
                    writer.write(entry.getValue().stream().map(String::valueOf).collect(Collectors.joining(" ")));
                    reader.close();
                    writer.close();
                    return;
                }
            }


            for (int j = k - 2; j >= 0; j--) {
                for (Map.Entry<Long, List<Integer>> entry : list.get(j).entrySet()) {
                    long newKey = entry.getKey() * nums[i];
                    if (newKey <= m && !list.get(j + 1).containsKey(newKey)) {
                        List<Integer> newList = new ArrayList<>(entry.getValue());
                        newList.add(i + 1);
                        list.get(j + 1).put(newKey, newList);
                    }
                }
            }


            Map<Long, List<Integer>> map = list.getFirst();
            if (!map.containsKey((long) nums[i])) {
                map.put((long) nums[i], new ArrayList<>(List.of(i + 1)));
            }
        }


        reader.close();
        writer.close();
        throw new RuntimeException();
    }
}

package yandex.coderun.random;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/diversity-scoring">task link</a><br>
 * test - OK
 */
public class DiversityScoring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Map<Integer, Integer> productType = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            productType.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        List<Integer> nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toList();

        List<Integer> cats = nums.stream().map(productType::get).toList();

        HashMap<Integer, Integer> iMap = new HashMap<>();
        int minDist = cats.size();

        for (int i = 0; i < cats.size(); i++) {
            int num = cats.get(i);
            if (iMap.containsKey(num)) {
                int dist = i - iMap.get(num);
                minDist = Math.min(minDist, dist);
            }
            iMap.put(num, i);
        }

        writer.write(String.valueOf(minDist));

        reader.close();
        writer.close();
    }
}

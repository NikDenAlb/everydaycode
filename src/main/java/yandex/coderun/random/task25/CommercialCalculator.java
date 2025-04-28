package yandex.coderun.random.task25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/commercial-calculator">task link</a><br>
 * test - OK
 */
public class CommercialCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        List<Long> nums = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).boxed().collect(Collectors.toList());

        Queue<Long> heap = new PriorityQueue<>(nums);
        long totalCost = 0;

        while (heap.size() > 1) {
            Long first = heap.poll();
            Long second = heap.poll();
            long sum = first + second;

            long cost = 5 * sum;
            totalCost += cost;
            heap.add(sum);
        }

        double doubleCoast = totalCost / 100.0;
        DecimalFormat df = new DecimalFormat("#0.00");
        String out = df.format(doubleCoast);

        writer.write(out);

        reader.close();
        writer.close();
    }
}

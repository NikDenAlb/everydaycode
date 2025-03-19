package yandex.coderun.random.task324;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://coderun.yandex.ru/problem/trading-ya-intern">task link</a><br>
 * test - OK
 */
public class TradingYaIntern {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] numsN = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numsM = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int d = Math.min(n, m);
        long out = 0;
        int[] dN = sumSmallestN(numsN, d);
        int[] dM = sumLargestN(numsM, d);
        for (int i = 0; i < d; i++) {
            if (dM[i] > dN[i]) {
                out += dM[i] - dN[i];
            } else {
                break;
            }
        }
        writer.write(String.valueOf(out));

        reader.close();
        writer.close();
    }

    static int[] sumLargestN(int[] numbers, int m) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        for (int number : numbers) {
            minHeap.add(number);
            if (minHeap.size() > m) {
                minHeap.poll();
            }
        }
        return minHeap.stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
    }

    static int[] sumSmallestN(int[] numbers, int m) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int number : numbers) {
            maxHeap.add(number);
            if (maxHeap.size() > m) {
                maxHeap.poll();
            }
        }
        return maxHeap.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}

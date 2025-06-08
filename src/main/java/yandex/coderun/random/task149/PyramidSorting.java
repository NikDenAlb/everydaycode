package yandex.coderun.random.task149;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a href="https://coderun.yandex.ru/problem/pyramid-sorting">task link</a><br>
 * test - OK
 */
public class PyramidSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine();
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        heapSort(nums);
        writer.write(Arrays.stream(nums).boxed().map(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }

    static void heapSort(int[] array) {
        int len = array.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(array, len, i);
        }

        for (int i = len - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    static void heapify(int[] array, int len, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < len && array[left] > array[max]) {
            max = left;
        }
        if (right < len && array[right] > array[max]) {
            max = right;
        }

        if (max != i) {
            swap(array, i, max);
            heapify(array, len, max);
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

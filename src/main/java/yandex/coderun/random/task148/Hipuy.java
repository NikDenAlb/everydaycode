package yandex.coderun.random.task148;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/hipuy">task link</a><br>
 * test - OK
 */
public class Hipuy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Heap heap = new Heap();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int[] command = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (command[0] == 0) {
                heap.insert(command[1]);
            } else {
                out.append(heap.extract()).append('\n');
            }
        }
        if (!out.isEmpty()) {
            out.setLength(out.length() - 1);
        }

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}

class Heap {
    int[] array;
    int size;

    Heap() {
        this.size = 0;
        this.array = new int[100000];
    }

    void insert(int k) {
        if (size == 0) {
            array[0] = k;
            size++;
            return;
        }

        int index = size;
        for (int l = 0; l < index; ) {
            int m = (l + index) / 2;
            if (array[m] < k) {
                l = m + 1;
            } else {
                index = m;
            }
        }
        System.arraycopy(array, index,
                array, index + 1,
                size - index);
        array[index] = k;
        size++;
    }

    int extract() {
        return array[--size];
    }
}

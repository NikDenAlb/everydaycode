package yandex.coderun.random.task150;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/three-blocks-row">task link</a><br>
 * test 34 - TL
 */
public class ThreeBlocksRowRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        writer.write(Integer.toString(calcThreeBlocksRow(n)));

        reader.close();
        writer.close();
    }

    static int calcThreeBlocksRow(int n) {
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 4;
        }
        if (n == 3) {
            return 7;
        }
        return calcThreeBlocksRow(n - 1) + calcThreeBlocksRow(n - 2) + calcThreeBlocksRow(n - 3);
    }
}

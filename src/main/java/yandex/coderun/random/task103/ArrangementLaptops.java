package yandex.coderun.random.task103;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/arrangement-laptops">task link</a><br>
 * test - OK
 */
public class ArrangementLaptops {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int lL1 = Integer.parseInt(input[0]);
        int wL1 = Integer.parseInt(input[1]);
        int lL2 = Integer.parseInt(input[2]);
        int wL2 = Integer.parseInt(input[3]);

        writer.write(defineTable(lL1, wL1, lL2, wL2));

        reader.close();
        writer.close();
    }

    static String defineTable(int lL1, int wL1, int lL2, int wL2) {
        int[] pos1 = defineUnFlipTable(lL1, wL1, lL2, wL2);
        int[] pos2 = defineUnFlipTable(lL1, wL1, wL2, lL2);

        if (pos1[0] * pos1[1] > pos2[0] * pos2[1]) {
            return pos2[0] + " " + pos2[1];
        } else {
            return pos1[0] + " " + pos1[1];
        }
    }

    static int[] defineUnFlipTable(int lL1, int wL1, int lL2, int wL2) {
        int lT, wT;

        int lTA = lL1 + lL2;
        int wTA = Math.max(wL1, wL2);

        int lTB = Math.max(lL1, lL2);
        int wTB = wL1 + wL2;

        if (lTA * wTA > lTB * wTB) {
            lT = lTB;
            wT = wTB;
        } else {
            lT = lTA;
            wT = wTA;
        }

        return new int[]{lT, wT};
    }
}

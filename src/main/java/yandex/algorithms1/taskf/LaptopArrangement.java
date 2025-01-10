package yandex.algorithms1.taskf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LaptopArrangement {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int lL1 = Integer.parseInt(input[0]);
        int wL1 = Integer.parseInt(input[1]);
        int lL2 = Integer.parseInt(input[2]);
        int wL2 = Integer.parseInt(input[3]);

        reader.close();

        System.out.println(defineTable(lL1, wL1, lL2, wL2));
    }

    public static String defineTable (int lL1, int wL1, int lL2, int wL2) {
        int[] pos1 = defineUnFlipTable(lL1, wL1, lL2, wL2);
        int[] pos2 = defineUnFlipTable(lL2, wL2, wL2, lL2);

        System.out.println("pos1 = " + Arrays.toString(pos1));
        System.out.println("pos2 = " + Arrays.toString(pos2));

        if (pos1[0] * pos1[1] > pos2[0] * pos2[1]) {
            return pos2[0] + " " + pos2[0];
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

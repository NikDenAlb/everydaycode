package yandex.algorithms1.taskf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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

    public static String defineTable(int lL1, int wL1, int lL2, int wL2) {
        int lT = lL1+lL2;
        int wT = wL1+wL2;


        return lT + " " + wT;
    }
}

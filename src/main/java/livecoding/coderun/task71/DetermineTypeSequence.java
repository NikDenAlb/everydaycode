package livecoding.coderun.task71;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
/*
[    0   |      1    |      2          |    3      |       4         ]
[CONSTANT, ASCENDING, WEAKLY ASCENDING, DESCENDING, WEAKLY DESCENDING]

                                    0[1,1,1,1,1]

    1[1,0,1,0,1]                    2[0,1,1,0,0]            3[0,0,0,1,1]

(1) 4[0,0,1,0,0] 5[0,0,0,0,1]       (4)(2)6[0,0,0,0,0]      (5)(6)(3)

     (4)(4)(6)    (5)(6)(5)
*/

/**
 * <a href="https://coderun.yandex.ru/problem/triangle">task link</a><br>
 * <a href="https://youtu.be/IRxXM5omL3c">video link</a>
 */
public class DetermineTypeSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        List<Integer> nums = new ArrayList<>();
        while (!(line = reader.readLine()).equals("-2000000000")) {
            nums.add(Integer.parseInt(line));
        }

        writer.write(determineTypeSequence(nums));

        reader.close();
        writer.close();
    }

    static String determineTypeSequence(List<Integer> nums) {
        int tCase = 0;
        for (int i = 1; i < nums.size(); i++) {
            tCase = checkStep(nums.get(i - 1), nums.get(i), tCase);
            if (tCase == 6) {
                return "RANDOM";
            }
        }
        return switch (tCase) {
            case 1 -> "CONSTANT";
            case 2 -> "ASCENDING";
            case 3 -> "DESCENDING";
            case 4 -> "WEAKLY ASCENDING";
            case 5 -> "WEAKLY DESCENDING";
            default -> throw new RuntimeException();
        };
    }

    static int checkStep(int a, int b, int tCase) {
        switch (tCase) {
            case 0:
                if (a == b) {
                    return 1;
                }
                if (b > a) {
                    return 2;
                }
                return 3;
            case 1:
                if (a == b) {
                    return 1;
                }
                if (b > a) {
                    return 4;
                }
                return 5;
            case 2:
                if (a == b) {
                    return 4;
                }
                if (b > a) {
                    return 2;
                }
                return 6;
            case 3:
                if (a == b) {
                    return 5;
                }
                if (b > a) {
                    return 6;
                }
                return 3;
            case 4:
                if (a > b) {
                    return 6;
                }
                return 4;
            case 5:
                if (b > a) {
                    return 6;
                }
                return 5;
        }
        throw new RuntimeException();
    }
}

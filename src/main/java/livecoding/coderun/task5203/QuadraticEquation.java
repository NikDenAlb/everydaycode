package livecoding.coderun.task5203;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * <a href="https://coderun.yandex.ru/problem/quadratic-equation">task link</a><br>
 * <a href="https://youtu.be/srn_yyyCyC8">video link</a><br>
 */
public class QuadraticEquation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(solveQuadraticEquation(nums[0], nums[1], nums[2]));

        reader.close();
        writer.close();
    }

    static String solveQuadraticEquation(int a, int b, int c) {
        int d = b * b - 4 * a * c;
        if (d < 0) {
            return "0";
        }

        StringBuilder out = new StringBuilder();

        if (d == 0) {
            out.append("1\n");
            out.append(-(double) b / (2 * a));
            return out.toString();
        }

        out.append("2\n");
        out.append((-b - Math.sqrt(d)) / (2 * a));
        out.append(" ");
        out.append((-b + Math.sqrt(d)) / (2 * a));

        return out.toString();
    }
}

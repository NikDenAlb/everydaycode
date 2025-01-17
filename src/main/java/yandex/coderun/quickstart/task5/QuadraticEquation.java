package yandex.coderun.quickstart.task5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/quadratic-equation">task link</a><br>
 * test - OK
 */
public class QuadraticEquation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] nums = reader.readLine().split(" ");
        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);
        int c = Integer.parseInt(nums[2]);

        double d = (double) b * b - 4 * a * c;

        if (d < 0) {
            writer.write("0");
        } else if (d == 0) {
            double x = (double) -b / (2 * a);
            writer.write("1\n" + x);
        } else {
            double sqrtD = Math.sqrt(d);
            double x1 = (-b - sqrtD) / (2 * a);
            double x2 = (-b + sqrtD) / (2 * a);
            if (x1 > x2) {
                writer.write("2\n" + x2 + " " + x1);
            } else {
                writer.write("2\n" + x1 + " " + x2);
            }
        }


        reader.close();
        writer.close();
    }
}

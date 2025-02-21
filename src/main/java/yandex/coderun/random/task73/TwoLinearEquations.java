package yandex.coderun.random.task73;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/system-of-linear-equations-2">task link</a><br>
 * test - OK
 */
public class TwoLinearEquations {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        double a = Double.parseDouble(reader.readLine());
        double b = Double.parseDouble(reader.readLine());
        double c = Double.parseDouble(reader.readLine());
        double d = Double.parseDouble(reader.readLine());
        double e = Double.parseDouble(reader.readLine());
        double f = Double.parseDouble(reader.readLine());

        writer.write(solveTwoLinearEquations(a, b, c, d, e, f));

        reader.close();
        writer.close();
    }

    /**
     * ax+by=c
     */
    static String solveTwoLinearEquations(double a1, double b1, double a2, double b2, double c1, double c2) {
        if (a1 == 0 && b1 == 0 && c1 == 0 && a2 == 0 && b2 == 0 && c2 == 0) {
            return "5";
        } else if (a1 * b2 == b1 * a2 && a1 * c2 != c1 * a2) {
            return "0";
        } else if (a1 == 0 && b1 == 0 && c1 != 0) {
            return "0";
        } else if (a2 == 0 && b2 == 0 && c2 != 0) {
            return "0";
        } else if (a1 == 0 && a2 == 0 && b1 * c2 != b2 * c1) {
            return "0";
        } else if (b1 == 0 && b2 == 0 && a1 * c2 != c1 * a2) {
            return "0";
        } else if (a1 * b2 == b1 * a2 && a1 * c2 == c1 * a2) {
            if (b1 == 0 && b2 == 0) {
                if (a1 != 0 && a2 != 0) {
                    return "3 " + c1 / a1;
                } else if (a1 == 0) {
                    return "3 " + c2 / a2;
                } else {
                    return "3 " + c1 / a1;
                }
            } else if (a1 == 0 && a2 == 0) {
                if (b1 != 0) {
                    return "4 " + c1 / b1;
                } else {
                    return "4 " + c2 / b2;
                }
            } else if (b1 != 0) {
                return "1 " + -a1 / b1 + " " + c1 / b1;
            } else {
                return "1 " + -a2 / b2 + " " + c2 / b2;
            }
        } else
            return "2 " + (c1 * b2 - b1 * c2) / (a1 * b2 - a2 * b1) + " " + (a1 * c2 - c1 * a2) / (a1 * b2 - a2 * b1);
    }
}

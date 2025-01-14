package yandex.algorithms1.part1ComplexityTestingSpecialCases.homework.taskd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * test - Ok
 */
public class RootEquation {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        reader.close();

        System.out.println(rootEquation(a, b, c));
    }

    /**
     * sqrt(a*x+b)=c решение в целых числах
     *
     * @param a параметр уравнения
     * @param b параметр уравнения
     * @param c параметр уравнения
     * @return решение или "NO SOLUTION"/"MANY SOLUTIONS" если решение не единственное
     */
    public static String rootEquation(int a, int b, int c) {
        if (c < 0) {
            return "NO SOLUTION";
        }
        if (a == 0) {
            if (b == c * c) {
                return "MANY SOLUTIONS";
            } else return "NO SOLUTION";
        }

        int temp = c * c - b;

        if (temp % a != 0) {
            return "NO SOLUTION";
        }

        return String.valueOf(temp / a);
    }
}

package yandex.algorithms1.part1ComplexityTestingSpecialCases.homework.taski;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * test - Ok
 */
public class PrisonerIf {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        reader.close();

        System.out.println(isBrickFit(a, b, c, d, e));
    }

    /**
     * @param a размер стороны кирпича
     * @param b размер стороны кирпича
     * @param c размер стороны кирпича
     * @param d размер стороны дыры
     * @param e размер стороны дыры
     * @return "YES"/"NO" можно ли кирпич просунуть в дыру
     */
    public static String isBrickFit(int a, int b, int c, int d, int e) {
        if (d >= a && e >= b ||
                d >= b && e >= a ||

                d >= a && e >= c ||
                d >= c && e >= a ||

                d >= b && e >= c ||
                d >= c && e >= b) {
            return "YES";
        }
        return "NO";
    }
}

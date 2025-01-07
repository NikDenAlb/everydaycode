package yandex.algorithms1.taskb;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * test - Ok
 */
public class Triangle {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        reader.close();

        System.out.println(isTriangle(a, b, c));
    }

    /**
     * @param a длина стороны
     * @param b длина стороны
     * @param c длина стороны
     * @return "YES" - треугольник возможен, "NO" - не возможен
     */
    public static String isTriangle(int a, int b, int c) {
        if (a < b + c && b < a + c && c < a + b) {
            return "YES";
        }
        return "NO";
    }
}

package yandex.algorithms1.taskd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RootEquation {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        reader.close();

        System.out.println(rootEquation(a, b, c));
    }

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

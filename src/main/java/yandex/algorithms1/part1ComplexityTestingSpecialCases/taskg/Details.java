package yandex.algorithms1.part1ComplexityTestingSpecialCases.taskg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * test - Ok
 */
public class Details {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);

        reader.close();

        System.out.println(defineDetails(n, k, m));
    }

    /**
     * @param n - масса сплава
     * @param k - масса заготовки
     * @param m - масса детали
     * @return количество полученных деталей
     */
    public static int defineDetails(int n, int k, int m) {
        if (k > n || m > k) {
            return 0;
        }

        int out = (n / k) * (k / m);

        n = n - m * out;

        while (n >= k) {
            int newOut = (n / k) * (k / m);
            out += newOut;
            n = n - m * newOut;
        }

        return out;
    }
}

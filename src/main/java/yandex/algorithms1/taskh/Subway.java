package yandex.algorithms1.taskh;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * test - Ok
 */
public class Subway {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        reader.close();

        System.out.println(defineWaitTime(a, b, n, m));
    }

    /**
     * @param a интервал между поездами первого пути
     * @param b интервал между поездами второго пути
     * @param n количество поездов на первом пути
     * @param m количество поездов на втором пути
     * @return интервал возможного значения ожидания. -1 - некорректные входные данные
     */
    public static String defineWaitTime(int a, int b, int n, int m) {
        int timeNStart = (1 + a) * (n - 1) + 1;
        int timeNEnd = timeNStart + 2 * a;
        int timeMStart = (1 + b) * (m - 1) + 1;
        int timeMEnd = timeMStart + 2 * b;

        int outStart = Math.max(timeNStart, timeMStart);
        int outEnd = Math.min(timeNEnd, timeMEnd);

        if (outStart > outEnd) {
            return "-1";
        }

        return outStart + " " + outEnd;
    }
}

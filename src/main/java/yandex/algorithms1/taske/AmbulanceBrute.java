package yandex.algorithms1.taske;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * test - Ok
 */
public class AmbulanceBrute {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int k1 = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k2 = Integer.parseInt(input[2]);
        int p2 = Integer.parseInt(input[3]);
        int n2 = Integer.parseInt(input[4]);

        reader.close();

        System.out.println(findAddressBrute(k1, m, k2, p2, n2));
    }

    /**
     * @param k1 номер искомой квартиры
     * @param m  общее число этажей. Они одинаков по количеству квартир
     * @param k2 номер второй квартиры
     * @param p2 номер подъезда второй квартиры
     * @param n2 номер этажа второй квартиры
     * @return p1 + " " + n1<br> 0 - определить невозможно<br> -1 - некорректные входные данные
     */
    public static String findAddressBrute(int k1, int m, int k2, int p2, int n2) {
        int p1 = -1;
        int n1 = -1;

        if (m < n2) {
            return p1 + " " + n1;
        }

        int maxQ = 1_000_000;
        int firstQ = 0;

        for (int i = 1; i <= maxQ; i++) {
            if (k2 > (long) m * i * (p2 - 1) + (long) (n2 - 1) * i
                    && k2 <= (long) m * i * (p2 - 1) + (long) n2 * i) {
                firstQ = i;
                break;
            }
        }
        if (firstQ == 0) {
            return p1 + " " + n1;
        }
        int lastQ = 0;

        for (int i = firstQ + 1; i <= maxQ; i++) {
            if (k2 > (long) m * i * (p2 - 1) + (long) (n2 - 1) * i
                    && k2 <= (long) m * i * (p2 - 1) + (long) n2 * i) {
                lastQ = i;
            } else
                break;
        }

        p1 = (int) ((k1 + (long) m * firstQ - 1) / ((long) m * firstQ));

        for (int i = firstQ + 1; i <= lastQ; i++) {
            int pNew = (int) ((k1 + (long) m * i - 1) / ((long) m * i));
            if (p1 != pNew) {
                p1 = 0;
                break;
            }
        }

        n1 = ((k1 + firstQ - 1) / firstQ) % m;
        if (n1 == 0) {
            n1 = m;
        }

        for (int i = firstQ + 1; i <= lastQ; i++) {
            int nNew = ((k1 + i - 1) / i) % m;
            if (nNew == 0) {
                nNew = m;
            }
            if (n1 != nNew) {
                n1 = 0;
                break;
            }
        }
        return p1 + " " + n1;
    }
}

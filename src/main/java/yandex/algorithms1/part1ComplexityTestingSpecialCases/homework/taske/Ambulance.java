package yandex.algorithms1.part1ComplexityTestingSpecialCases.homework.taske;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//TODO Задача решена в классе AmbulanceBrute. Добиться решения этим
public class Ambulance {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        long k1 = Integer.parseInt(input[0]);
        long m = Integer.parseInt(input[1]);
        long k2 = Integer.parseInt(input[2]);
        long p2 = Integer.parseInt(input[3]);
        long n2 = Integer.parseInt(input[4]);

        reader.close();

        System.out.println(findAddress(k1, m, k2, p2, n2));
    }

    /**
     * @param k1 номер искомой квартиры
     * @param m  общее число этажей. Они одинаков по количеству квартир
     * @param k2 номер второй квартиры
     * @param p2 номер подъезда второй квартиры
     * @param n2 номер этажа второй квартиры
     * @return p1 + " " + n1<br> 0 - определить невозможно<br> -1 - некорректные входные данные
     */
    public static String findAddress(long k1, long m, long k2, long p2, long n2) {

//        (p*m + (n-1)) * q < k <= (p*m + n) * q

//    qMin           q >=  k/(p*m + n)
//                                           |1 2 3 4| |5 6 7 8| |9 10 11 12|//|13 14 15 16| |17 18 19 20| |21 22 23 24|
//                  dk = q


        long qMin;
        long qMax;
        long n1 = -1;
        long p1 = -1;


        if ((p2 - 1) * m + (n2 - 1) < k2 && k1 % m < n2 && k2 % m < n2) {

            if ((p2 - 1) * m + n2 - 1 == 0) {
                qMax = Integer.MAX_VALUE;
            } else {
                qMax = k2 / ((p2 - 1) * m + n2 - 1);
                if (k2 % ((p2 - 1) * m + n2 - 1) == 0) {
                    qMax++;
                }
            }

            qMin = k2 / ((p2 - 1) * m + n2);
            if (k2 % ((p2 - 1) * m + n2) != 0) {
                qMin++;
            }

            p1 = k1 / (qMin * m);
            if (k1 / (qMin * m) != 0) {
                p1++;
            }

            long pMax = k1 / ((qMax - 1) * m);
            if (k1 / ((qMax - 1) * m) != 0) {
                pMax++;
            }
            if (p1 != pMax) {
                p1 = 0;
            }

            n1 = (k1 / qMin) % m;
            if (n1 == 0) {
                n1++;
            }

            if (k1 % qMin != 0) {
                n1 = (n1 + 1) % m;
                if (n1 == 0) {
                    n1++;
                }
            }

            for (long i = qMin + 1; i < pMax; i++) {
                long nNew = (k1 / i) % (m - 1) + 1;
                if (nNew == 0) {
                    nNew++;
                }
                if (k1 % i != 0) {
                    nNew = (nNew + 1) % m;
                    if (nNew == 0) {
                        nNew++;
                    }
                }
                if (nNew != n1) {
                    n1 = 0;
                    break;
                }
            }
        }
        return p1 + " " + n1;
    }
}

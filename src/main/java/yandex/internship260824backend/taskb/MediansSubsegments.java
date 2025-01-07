package yandex.internship260824backend.taskb;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * test - TL
 */
public class MediansSubsegments {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int b = Integer.parseInt(firstLine[1]);

        String[] nums = reader.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(nums[i]);
        }

        reader.close();

        System.out.println(mediansSubsegments(n, b, a));
    }

    /**
     * @param n длина перестановки
     * @param b медиана
     * @param a перестановка чисел
     * @return количество подотрезков с медианой равной b
     */
    public static int mediansSubsegments(int n, int b, int[] a) {
        int count = 0;

        int indexB = -1;

        for (int i = 0; i < n; i++) {
            if (a[i] == b) {
                indexB = i;
                break;
            }
        }

        int[] moreLessR = new int[n - indexB];
        moreLessR[0] = 0; //Интегрируем слева в правый массив случай отсутствия движения вправо для удобства работы с циклами
        int[] moreLessL = new int[indexB];

        for (int i = 0; i < moreLessR.length - 1; i++) {
            moreLessR[i + 1] = a[indexB + 1 + i] > b ? 1 : -1;
        }

        for (int i = 0; i < moreLessL.length; i++) {
            moreLessL[i] = a[indexB - 1 - i] > b ? 1 : -1;
        }

        int balanceR = 0;
        for (int j : moreLessR) {
            balanceR += j;
            if (balanceR == 0) {
                count++;
            }

            int balanceL = 0;
            for (int k : moreLessL) {
                balanceL += k;
                if (balanceR + balanceL == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

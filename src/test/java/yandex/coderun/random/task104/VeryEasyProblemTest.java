package yandex.coderun.random.task104;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static yandex.coderun.random.task104.VeryEasyProblem.findMinTime;


//   (n - Math.min(x, y)) * x * y + x + y - 1) / (x + y) + 1)


class VeryEasyProblemTest {

    @Test
    public void testRandomSequences() {
        Random random = new Random();
        boolean foundDiscrepancy = false;

        while (!foundDiscrepancy) {
            int[] arr = random.ints(3, 1, 101).toArray(); // Генерация чисел от 0 до 99

            int n = arr[0];
            int x = arr[1];
            int y = arr[2];

            int result1 = findMinTime(n, x, y);
            int result2 = MinimumCopyTime(n, x, y);

            if (result1 != result2) {
                System.out.println("Discrepancy found for array: " + java.util.Arrays.toString(arr));
                System.out.println("needSolution returned: " + result1);
                System.out.println("simpleSolution returned: " + result2);
                foundDiscrepancy = true;
            }
        }
    }


    static int MinimumCopyTime(int n, int x, int y) {

        n--;
        int l = 0;
        int r = n * Math.max(x, y);

        while (l < r) {
            int m = (l + r) / 2;
            if ((m / x + m / y) < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return (r + Math.min(x, y));

    }

}

/*
Discrepancy found for array: [67, 14, 90]
needSolution returned: 644
simpleSolution returned: 824

644-14=630
45
7

824-14=810

57

9



 */

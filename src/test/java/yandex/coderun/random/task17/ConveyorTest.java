package yandex.coderun.random.task17;

import org.junit.jupiter.api.Test;

import java.util.Random;

//TODO
class ConveyorTest {

    @Test
    public void testRandomSequences() {
        Random random = new Random();
        boolean foundDiscrepancy = false;

        while (!foundDiscrepancy) {
            int[] arr = random.ints(5, 0, 100).toArray(); // Генерация чисел от 0 до 99

            boolean result1 = needSolution(arr);
            boolean result2 = simpleSolution(arr);

            if (result1 != result2) {
                System.out.println("Discrepancy found for array: " + java.util.Arrays.toString(arr));
                System.out.println("needSolution returned: " + result1);
                System.out.println("simpleSolution returned: " + result2);
                foundDiscrepancy = true;
            }
        }
    }

    static boolean needSolution(int[] arr) {
        double min = arr[0], minActive = Double.MAX_VALUE;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] < min) {
                if (arr[i] < minActive) {
                    return false;
                }
                min = arr[i];
            } else if (arr[i] > min) {
                minActive = min;
            }
        }
        return true;
    }

    static boolean simpleSolution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (flag && arr[j] < arr[i]) {
                    return false;
                }
                if (arr[j] > arr[i]) {
                    flag = true;
                }
            }
        }
        return true;
    }

}



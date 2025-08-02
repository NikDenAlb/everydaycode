package yandex.coderun.cbc2025.task20;

import java.util.Arrays;
import java.util.Random;

public class StressTester {
    private static final Random random = new Random();

    public static void main(String[] args) {
        PrimitiveSolution correctSolution = new PrimitiveSolution();
        Solution testedSolution = new Solution();

        int testCount = 0;

        while (true) {
            testCount++;

            // Generate random input data
            int n = 0; // n is always 0
            int k = generateRandomK();
            int[] array = generateRandomArray();

            // Calculate results
            long correctResult = correctSolution.calculateAnswer(n, k, array);
            long testedResult = testedSolution.calculateAnswer(n, k, array);

            // Check results
            if (correctResult != testedResult) {
                System.out.println("Discrepancy found!");
                System.out.println("Input data:");
                System.out.println("n = " + n);
                System.out.println("k = " + k);
                System.out.println("Array: " + Arrays.toString(array));
                System.out.println("Correct result: " + correctResult);
                System.out.println("Tested result: " + testedResult);
                break;
            }

            if (testCount % 1000 == 0) {
                System.out.println("Tests performed: " + testCount);
            }
        }
    }

    // Generate random k value (from 1 to maximum possible)
    private static int generateRandomK() {
        return random.nextInt(1, 16);
    }

    // Generate random array with values from 1 to 200000
    private static int[] generateRandomArray() {
        int arraySize = random.nextInt(2, 5); // Array size from 1 to 4
        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(1, 25);
        }

        return array;
    }
}

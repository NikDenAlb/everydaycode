package yandex.coderun.cbc2025.task23;

import java.util.Arrays;
import java.util.Random;

public class TestRunner {

    public static void main(String[] args) {
        Random random = new Random();
        int testCount = 0;

        while (true) {
            testCount++;

            // Generate random array size
            int n = random.nextInt(4) + 1; // from 1 to 6

            // Generate array of random numbers
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = random.nextInt(11); // from 0 to 10
            }

            // Create class instances
            PrimitiveSolution ps = new PrimitiveSolution();
            Solution sol = new Solution();

            // Get results
            int[] result1 = ps.calculateAnswer(n, a);
            int[] result2 = sol.calculateAnswer(n, a);

            // Compare results
            if (!Arrays.equals(result1, result2)) {
                System.out.println("Discrepancy found in test №" + testCount);
                System.out.println("Input data:");
                System.out.println("n = " + n);
                System.out.println("Array: " + Arrays.toString(a));

                System.out.println("\nResults:");
                System.out.println("Reference solution: " + Arrays.toString(result1));
                System.out.println("Your solution: " + Arrays.toString(result2));
                break;
            }

            System.out.println("Test " + testCount + " passed successfully");
        }
    }
}

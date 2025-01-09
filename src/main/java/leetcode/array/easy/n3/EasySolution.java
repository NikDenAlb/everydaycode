package leetcode.array.easy.n3;

import java.util.Arrays;

/**
 * My 1st solution
 */
public class EasySolution implements Solution {

    @Override
    public boolean checkValid(int[][] matrix) {
        int[] expected = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            expected[i] = i + 1;
        }

        for (int[] ints : matrix) {
            int[] actual = Arrays.copyOf(ints, ints.length);
            Arrays.sort(actual);
            if (!Arrays.equals(expected, actual)) {
                return false;
            }
        }

        int[] actual = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                actual[j] = matrix[j][i];
            }
            Arrays.sort(actual);
            if (!Arrays.equals(expected, actual)) {
                return false;
            }
        }
        return true;
    }
}

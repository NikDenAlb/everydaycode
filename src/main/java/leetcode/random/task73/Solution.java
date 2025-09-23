package leetcode.random.task73;

import java.util.Arrays;

class Solution {
    void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        if (matrix[0][0] == 0) {
            row = true;
            col = true;
        }
        for (int i = 1; !row && i < n; i++) {
            if (matrix[0][i] == 0) {
                row = true;
                break;
            }
        }
        for (int i = 1; !col && i < m; i++) {
            if (matrix[i][0] == 0) {
                col = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (row) {
            Arrays.fill(matrix[0], 0);
        }
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
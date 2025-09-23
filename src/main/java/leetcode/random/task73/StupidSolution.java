package leetcode.random.task73;

class StupidSolution {
    void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = Integer.MAX_VALUE - 3;
                        }
                    }
                    for (int k = 0; k < n; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = Integer.MAX_VALUE - 3;
                        }
                    }
                    matrix[i][j] = Integer.MAX_VALUE - 3;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE - 3) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

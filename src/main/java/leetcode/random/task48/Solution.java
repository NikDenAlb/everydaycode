package leetcode.random.task48;

class Solution {
    void rotate(int[][] matrix) {
        for (int x = 0; x <= matrix.length / 2; x++){
            for (int y = 0; y <= matrix.length / 2; y++){
                int t = matrix[x][y];
                matrix[x][y] = matrix[matrix.length - x - 1][y];
                matrix[matrix.length - x - 1][y] = matrix[matrix.length - x - 1][matrix.length - y - 1];
                matrix[matrix.length - x - 1][matrix.length - y - 1] = matrix[x][matrix.length - y - 1];
                matrix[x][matrix.length - y - 1] = t;
            }
        }
    }
}
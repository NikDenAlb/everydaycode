package leetcode.random.task74;

class Solution {
    boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length * matrix[0].length;
        int n = matrix[0].length;
        int l = 0;
        for (int r = m - 1; l <= r; ) {
            int mid = (l + r) / 2;
            if (matrix[mid / n][mid % n] < target) {
                l = mid + 1;
            } else if (matrix[mid / n][mid % n] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
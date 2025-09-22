package leetcode.random.task54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> out = new ArrayList<>();
        for (int l = 0, r = matrix[0].length - 1, b = matrix.length - 1, h = 0; l <= r && h <= b; ) {
            for (int i = l; i <= r; i++) {
                out.add(matrix[h][i]);
            }
            h++;
            if (h <= b) {
                for (int i = h; i <= b; i++) {
                    out.add(matrix[i][r]);
                }
                r--;
            }
            if (h <= b && l <= r) {
                for (int i = r; i >= l; i--) {
                    out.add(matrix[b][i]);
                }
                b--;
            }
            if (h <= b && l <= r) {
                for (int i = b; i >= h; i--) {
                    out.add(matrix[i][l]);
                }
                l++;
            }
        }
        return out;
    }
}
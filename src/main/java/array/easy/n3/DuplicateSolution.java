package array.easy.n3;

/**
 * duplicate Solution from user
 */
public class DuplicateSolution  implements Solution {
    public boolean checkValid(int[][] matrix) {
        for (int[] value : matrix) {
            boolean[] exist = new boolean[100];
            for (int col = 0; col < matrix.length; col++) {
                if (exist[value[col] - 1]) return false;
                exist[value[col] - 1] = true;
            }
        }

        for (int col = 0; col < matrix.length; col++) {
            boolean[] exist = new boolean[100];
            for (int[] ints : matrix) {
                if (exist[ints[col] - 1]) return false;
                exist[ints[col] - 1] = true;
            }
        }
        return true;
    }
}

package array.easy.n1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15},9)) = " + Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("Arrays.toString(solution.twoSum(new int[]{3,2,4}, 6)) = " + Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println("Arrays.toString(solution.twoSum(new int[]{3,3}, 6)) = " + Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));
    }
}

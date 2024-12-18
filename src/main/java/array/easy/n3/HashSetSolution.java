package array.easy.n3;

import java.util.HashSet;

/**
 * ✅Easy Java solution||HashSet||Beginner Friendly🔥||✔️ Best Method<br>
 * Use for loops to check each row for every number from 1 to n. Similarly, do the same for each column.<br>
 * For each check, you can keep a set of the unique elements in the checked row/col. By the end of the check, the size of the set should be n.<br>
 * <a href="https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/solutions/2513380/easy-java-solution-hashset-beginner-friendly-best-method/">link</a>
 */
class HashSetSolution implements Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int[] value : matrix) {
            HashSet<Integer> hs = new HashSet<>();
            for (int j = 0; j < n; j++) {
                hs.add(value[j]);
            }
            if (hs.size() != n) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            HashSet<Integer> hs = new HashSet<>();
            for (int[] ints : matrix) {
                hs.add(ints[i]);
            }
            if (hs.size() != n) {
                return false;
            }
        }
        return true;
    }
}

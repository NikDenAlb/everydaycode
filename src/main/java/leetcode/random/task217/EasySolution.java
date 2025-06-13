package leetcode.random.task217;

import java.util.HashSet;
import java.util.Set;

class EasySolution {
    boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}

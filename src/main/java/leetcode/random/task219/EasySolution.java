package leetcode.random.task219;

import java.util.HashSet;
import java.util.Set;

class EasySolution {
    boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        for ( ; i <= k && i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        for ( ; i < nums.length; i++) {
            set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}

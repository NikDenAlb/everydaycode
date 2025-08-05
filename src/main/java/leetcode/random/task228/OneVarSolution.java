package leetcode.random.task228;

import java.util.ArrayList;
import java.util.List;

/**
 * Was too lazy to try it myself
 */
class OneVarSolution {
    List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int track = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                if (track == i) {
                    list.add(String.valueOf(nums[track]));
                } else {
                    list.add(nums[track] + "->" + nums[i]);
                }
                track = i + 1;
            }
        }
        return list;
    }
}

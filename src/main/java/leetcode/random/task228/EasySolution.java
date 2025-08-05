package leetcode.random.task228;

import java.util.ArrayList;
import java.util.List;

class EasySolution {
    List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        List<String> out = new ArrayList<>();
        int curS = nums[0], curE = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curE + 1) {
                curE++;
            } else {
                if (curE == curS) {
                    out.add(String.valueOf(curS));
                } else {
                    out.add(curS + "->" + curE);
                }
                curS = nums[i];
                curE = nums[i];
            }
        }
        if (curE == curS) {
            out.add(String.valueOf(curS));
        } else {
            out.add(curS + "->" + curE);
        }
        return out;
    }
}

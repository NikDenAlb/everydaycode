package leetcode.random.task15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);
        for (int l = 0; l < nums.length - 2; l++) {
            if (l > 0 && nums[l] == nums[l - 1]) {
                continue;
            }
            for (int m = l + 1, r = nums.length - 1; m < r; ) {
                int sum = nums[l] + nums[m] + nums[r];
                if (sum < 0) {
                    m++;
                } else if (sum > 0) {
                    r--;
                } else {
                    out.add(List.of(nums[l], nums[m], nums[r]));
                    while (m < r && nums[m] == nums[m + 1]) {
                        m++;
                    }
                    while (m < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    m++;
                    r--;
                }
            }
        }
        return out;
    }
}


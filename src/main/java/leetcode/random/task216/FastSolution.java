package leetcode.random.task216;

import java.util.ArrayList;
import java.util.List;

/**
 * Don't calc sum everytime
 */
class FastSolution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> nums = new ArrayList<>();

        combinationSum3Util(n, 1, nums, k, ans);
        return ans;
    }

    void combinationSum3Util(int sum, int last, List<Integer> nums, int k, List<List<Integer>> ans) {
        if (sum == 0 && nums.size() == k) {
            ans.add(new ArrayList<>(nums));
            return;
        }
        if (sum <= 0 || nums.size() > k) return;

        for (int i = last; i <= 9; i++) {
            if (i <= sum) {
                nums.add(i);
                combinationSum3Util(sum - i, i + 1, nums, k, ans);
                nums.removeLast();
            } else {
                break;
            }
        }
    }
}
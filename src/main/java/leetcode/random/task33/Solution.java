package leetcode.random.task33;

class Solution {
    int search(int[] nums, int target) {
        int b = 0;
        for (int r = nums.length - 1; b < r; ) {
            int m = b + (r - b + 1) / 2;
            if (nums[m] > nums[0]) {
                b = m;
            } else {
                r = m - 1;
            }
        }
        if (target >= nums[0]) {
            int out = 0;
            for (int r = b; out < r; ) {
                int m = out + (r - out) / 2;
                if (nums[m] > target) {
                    r = m - 1;
                } else if (nums[m] < target) {
                    out = m + 1;
                } else {
                    return m;
                }
            }
            return nums[out] == target ? out : -1;
        }
        if (b == nums.length - 1) {
            return -1;
        }
        int out = b + 1;
        for (int r = nums.length - 1; out < r; ) {
            int m = out + (r - out) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                out = m + 1;
            } else {
                return m;
            }
        }
        return nums[out] == target ? out : -1;
    }
}

//  [a----------------bc---------------------d]
//  [c----------------ad---------------------b]
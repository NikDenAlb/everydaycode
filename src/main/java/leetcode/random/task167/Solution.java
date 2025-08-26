package leetcode.random.task167;

class Solution {
    int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (r > l) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] == target) {
                return new int[]{l + 1, r + 1};
            } else {
                l++;
            }
        }
        throw new RuntimeException();
    }
}
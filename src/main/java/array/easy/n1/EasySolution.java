package array.easy.n1;

/**
 *Time complexity: O(n*2)
 * For each element, we try to find its complement by looping through the rest of the array which takes O(n) time.<br>
 * Space complexity: O(1).
 * The space required does not depend on the size of the input array, so only constant space is used.
 */
class EasySolution implements Solution {

    @Override
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

package array.easy.n1;

import java.util.HashMap;

/**
 * Time complexity: O(n).
 * We traverse the list containing n elements only once. Each lookup in the table costs only O(1) time.<br>
 * Space complexity: O(n).
 * The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
 */
class HashSolution implements Solution {
    @Override
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{i, map.get(x)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

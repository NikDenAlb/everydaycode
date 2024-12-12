package array.easy.n2;

import java.util.HashMap;

/**
 * Good solution with HashMap from LeetCode
 */
public class HashSolution implements Solution {
    @Override
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int num : nums) {
            if(num % 2 == 0) {
                hash.put(num, hash.getOrDefault(num, 0)  + 1);
            }
        }
        int ans = -1;
        int count = 0;
        for (HashMap.Entry<Integer, Integer> i : hash.entrySet()) {
            if (count == i.getValue()) {
                ans = Math.min(ans, i.getKey());
            }
            if(i.getValue() > count) {
                count = i.getValue();
                ans = i.getKey();
            }
        }
        return ans;
    }
}

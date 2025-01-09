package leetcode.array.easy.n2;

import java.util.HashMap;
import java.util.Map;

/**
 * My 1st solution
 */
class EasySolution implements Solution {

    @Override
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        if (map.isEmpty()) return -1;

        int frequency = map.values().stream().max(Integer::compareTo).get();

        return map.keySet().stream()
                .filter(e -> map.get(e) == frequency)
                .min(Integer::compareTo).get();
    }
}

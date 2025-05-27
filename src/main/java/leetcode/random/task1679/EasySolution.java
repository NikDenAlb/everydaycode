package leetcode.random.task1679;

import java.util.HashMap;
import java.util.Map;

class EasySolution {
    int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int eCount = 0;
        for (int a : nums) {
            if (a < k) {
                int b = k - a;
                if (a == b) {
                    eCount++;
                } else if (a < b) {
                    map.put(a, map.getOrDefault(a, 0) + 1);
                    if (map.get(a) <= 0) {
                        count++;
                    }
                } else {
                    map.put(b, map.getOrDefault(b, 0) - 1);
                    if (map.get(b) >= 0) {
                        count++;
                    }
                }
            }
        }
        return count + eCount / 2;
    }
}

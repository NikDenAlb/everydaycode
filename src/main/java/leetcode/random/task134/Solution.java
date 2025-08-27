package leetcode.random.task134;

import java.util.Arrays;

class Solution {
    int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        for (int i = 0; i < gas.length; ) {
            boolean isPossible = true;
            for (int j = i, g = 0; j < gas.length; j++) {
                g += gas[j] - cost[j];
                if (g < 0) {
                    isPossible = false;
                    i = j + 1;
                    break;
                }
            }
            if (isPossible) {
                return i;
            }
        }
        throw new RuntimeException();
    }
}

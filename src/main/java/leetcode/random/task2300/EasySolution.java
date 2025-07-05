package leetcode.random.task2300;

import java.util.Arrays;

class EasySolution {
    int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            spells[i] = bs(potions, spells[i], success);
        }
        return spells;
    }

    int bs(int[] p, int spell, long g) {
        int l = 0;
        for (int r = p.length - 1; l <= r; ) {
            int m = l + (r - l) / 2;
            long prod = (long) spell * p[m];
            if (prod < g) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return p.length - l;
    }
}

package leetcode.random.task274;

import java.util.Arrays;

class EasySolution {
    int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0, j = citations.length; i < citations.length; i++, j--) {
            if (citations[i] >= j) {
                return j;
            }
        }
        return 0;
    }
}

package yandex.coderun.cbc2025.task15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/three-letter-ballad">task link</a><br>
 * test - OK
 */
class Solution {
    public static long solve(String ballad, int n) {
        ballad = ballad.replace(" ", "");
        Map<Character, List<Integer>> map = new HashMap<>();
        long out = 0;
        for (int i = 0; i < ballad.length(); i++) {
            char curChar = ballad.charAt(i);
            if (map.containsKey(curChar)) {
                List<Integer> list = map.get(curChar);
                list.add(i);
            } else {
                List<Integer> inds = new ArrayList<>();
                inds.add(i);
                map.put(curChar, inds);
            }
        }
        for (List<Integer> inds : map.values()) {
            if (inds.size() < 2) {
                continue;
            }
            long totalSum = 0;
            for (int index : inds) {
                totalSum += index;
            }
            long prefixSum = 0;
            for (int i = 0; i < inds.size(); i++) {
                int currInd = inds.get(i);
                long rightSum = totalSum - prefixSum - currInd;
                long countRight = inds.size() - i - 1;
                out += rightSum - countRight * currInd - countRight;
                prefixSum += currInd;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Solution.solve("treasure", 1));
        //8
        System.out.println(Solution.solve("you will never find the treasure", 2));
        //146
    }
}

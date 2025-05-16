package leetcode.random.task1431;

import java.util.Arrays;
import java.util.List;

class EasySolution {
    List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int m = Arrays.stream(candies).max().orElseThrow();
        return Arrays.stream(candies).mapToObj(x -> x + extraCandies >= m).toList();
    }
}

package leetcode.array.easy.n4;

public class EasySolution implements Solution {
    public int minCostClimbingStairs(int[] cost) {
        int stepS = cost[0], copyStepS = cost[0], stepF = cost[1];
        for (int i = 1; i < cost.length - 1; i++) {
            stepS = Math.min(stepS + cost[i], stepF);
            stepF = Math.min(copyStepS, stepS) + cost[i + 1];
            copyStepS = stepS;
        }
        return Math.min(stepS, stepF);
    }
}

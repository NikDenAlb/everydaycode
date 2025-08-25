package leetcode.random.task139;

import java.util.List;

class Solution {
    boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (String w : wordDict) {
            if (w.length() <= s.length() && s.startsWith(w)) {
                dp[w.length() - 1] = true;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String w : wordDict) {
                int j = i + w.length();
                if (j < s.length() && s.substring(i + 1, j + 1).equals(w)) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
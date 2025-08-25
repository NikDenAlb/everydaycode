package leetcode.random.task139;

import java.util.ArrayList;
import java.util.List;

class MLSolution {
    boolean wordBreak(String s, List<String> wordDict) {
        List<StringBuilder> list = new ArrayList<>();
        for (String w : wordDict) {
            if (s.startsWith(w)) {
                if (w.length() == s.length()) return true;
                list.add(new StringBuilder(s.substring(w.length())));
            }
        }
        while (!list.isEmpty()) {
            List<StringBuilder> newList = new ArrayList<>();
            for (StringBuilder str : list) {
                for (String w : wordDict) {
                    if (w.length() <= str.length() && str.substring(0, w.length()).equals(w)) {
                        if (w.length() == str.length()) return true;
                        newList.add(new StringBuilder(str.substring(w.length())));
                    }
                }
            }
            list = newList;
        }
        return false;
    }
}
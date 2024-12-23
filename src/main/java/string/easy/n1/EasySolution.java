package string.easy.n1;

import java.util.ArrayList;
import java.util.List;

public class EasySolution implements Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> out = new ArrayList<>();
        char curChar = s.charAt(0);
        int indexStart = 0;
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (curChar == s.charAt(i)) {
                count++;
            } else {
                if (count >= 3) {
                    out.add(List.of(indexStart, indexStart + count - 1));
                }
                curChar = s.charAt(i);
                indexStart = i;
                count = 1;
            }
            if (i == s.length() - 1 && count >= 3) {
                out.add(List.of(indexStart, indexStart + count - 1));
            }
        }
        return out;
    }
}

package leetcode.random.task118;

import java.util.ArrayList;
import java.util.List;

class EasySolution {
    List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<>(numRows);
        out.add(new ArrayList<>(List.of(1)));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> prev = out.getLast();
            List<Integer> curr = new ArrayList<>(i);
            out.add(curr);
            curr.add(1);
            for (int j = 1; j < i - 1; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
        }
        return out;
    }
}

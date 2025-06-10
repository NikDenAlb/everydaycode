package leetcode.random.task119;

import java.util.ArrayList;
import java.util.List;

class EasySolution {
    List<Integer> getRow(int rowIndex) {
        List<Integer> out = new ArrayList<>(++rowIndex);
        out.add(1);
        if (rowIndex == 2) {
            out.add(1);
            return out;
        }
        int e = 1, i = 1;
        for (; i < (rowIndex + 1) / 2; i++) {
            e = (int) ((long) e * (rowIndex - i) / i);
            out.add(e);
        }
        if (rowIndex % 2 == 1) {
            for (i -= 2; i >= 0; i--) {
                out.add(out.get(i));
            }
        } else {
            for (i--; i >= 0; i--) {
                out.add(out.get(i));
            }
        }
        return out;
    }
}

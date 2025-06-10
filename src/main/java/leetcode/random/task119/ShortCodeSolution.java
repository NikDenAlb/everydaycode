package leetcode.random.task119;

import java.util.ArrayList;
import java.util.List;

/**
 * Almost as good and same as mine. Simple and short
 */
class ShortCodeSolution {
    List<Integer> getRow(int rowIndex) {
        long n = 1;
        List<Integer> a = new ArrayList<>();
        a.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            n = n * (rowIndex + 1 - i);
            n = n / i;
            a.add((int) n);
        }
        return a;
    }
}

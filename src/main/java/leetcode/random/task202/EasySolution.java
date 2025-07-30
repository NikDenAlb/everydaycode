package leetcode.random.task202;

import java.util.HashSet;
import java.util.Set;

class EasySolution {
    boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            n = replace(n);
        }
        return n == 1;
    }

    int replace(int n) {
        int out = 0;
        while (n > 0) {
            int a = n % 10;
            out += a * a;
            n /= 10;
        }
        return out;
    }
}

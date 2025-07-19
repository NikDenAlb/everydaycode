package leetcode.random.task2336;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class SmallestInfiniteSet {
    int cur;
    Set<Integer> s;

    public SmallestInfiniteSet() {
        cur = 1;
        s = new HashSet<>();
    }

    public int popSmallest() {
        if (!s.isEmpty()) {
            int min = Collections.min(s);
            s.remove(min);
            return min;
        } else {
            cur++;
            return cur - 1;
        }
    }

    public void addBack(int num) {
        if (cur > num) {
            s.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
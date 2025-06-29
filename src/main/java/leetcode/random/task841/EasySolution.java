package leetcode.random.task841;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class EasySolution {
    Set<Integer> keys;
    boolean[] vstd;

    boolean canVisitAllRooms(List<List<Integer>> rooms) {
        keys = new HashSet<>();
        keys.addAll(rooms.getFirst());
        vstd = new boolean[rooms.size()];
        vstd[0] = true;
        while(knockKnock(rooms));
        for (int i = 1; i < vstd.length; i++) {
            if (!vstd[i]) {
                return false;
            }
        }
        return true;
    }

    boolean knockKnock(List<List<Integer>> rooms) {
        for (int i = 1; i < vstd.length; i++) {
            if (!vstd[i] && keys.contains(i)) {
                keys.addAll(rooms.get(i));
                vstd[i] = true;
                return true;
            }
        }
        return false;
    }
}

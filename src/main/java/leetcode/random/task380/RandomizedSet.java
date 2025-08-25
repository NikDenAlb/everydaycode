package leetcode.random.task380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random rnd;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rnd = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int i = map.get(val);
        map.remove(val);
        if (i == list.size() - 1) {
            list.remove(i);
            return true;
        }
        list.set(i, list.getLast());
        map.put(list.get(i), i);
        list.removeLast();
        return true;
    }

    public int getRandom() {
        return list.get(rnd.nextInt(list.size()));
    }
}

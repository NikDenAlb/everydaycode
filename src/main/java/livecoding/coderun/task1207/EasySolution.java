package livecoding.coderun.task1207;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class EasySolution {
    boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(e -> map.put(e, map.getOrDefault(e, 0) + 1));
        return map.size() == new HashSet<>(map.values()).size();
    }
}

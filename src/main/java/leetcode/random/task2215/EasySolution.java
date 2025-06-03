package leetcode.random.task2215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class EasySolution {
    List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> both = new HashSet<>(set1);
        both.retainAll(set2);
        List<List<Integer>> out = new ArrayList<>();
        set1.removeAll(both);
        out.add(set1.stream().toList());
        set2.removeAll(both);
        out.add(set2.stream().toList());
        return out;
    }
}

package yandex.coderun.cbc2025.task23;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeepSeek {

    public static void main(String[] args) throws IOException {
        BinSolution solution = new BinSolution();
        System.out.println(Arrays.toString(solution.calculateAnswer(1, new int[]{1})));
        //0 0 0 0
        System.out.println(Arrays.toString(solution.calculateAnswer(2, new int[]{0, 1})));
        //0 2 0 2
        System.out.println(Arrays.toString(solution.calculateAnswer(3, new int[]{0, 0, 0})));
        //1 1 0 1
        System.out.println(Arrays.toString(solution.calculateAnswer(4, new int[]{0, 0, 1, 2})));
        //0 3 0 3
        System.out.println(Arrays.toString(solution.calculateAnswer(5, new int[]{4, 3, 0, 2, 1})));
        //1 5 0 5
        System.out.println(Arrays.toString(solution.calculateAnswer(6, new int[]{4, 1, 0, 2, 3, 1})));
        //3 5 0 5


        System.out.println(Arrays.toString(solution.calculateAnswer(3, new int[]{0, 6, 0})));
        //[0, 6, 0, 1]
        System.out.println(Arrays.toString(solution.calculateAnswer(2, new int[]{6, 2})));
        //[0, 6, 0, 0]
        System.out.println(Arrays.toString(solution.calculateAnswer(3, new int[]{1, 0, 1})));
        //[1, 2, 0, 2]
    }

    int[] calculateAnswer(int n, int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int num : a) {
            set.add(num);
        }
        int maxG = 0;
        while (set.contains(maxG)) {
            maxG++;
        }

        boolean[] b = new boolean[n];
        Arrays.fill(b, true);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= maxG; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (a[i] <= maxG && a[i] >= 0) {
                lists.get(a[i]).add(i);
            }
        }

        int minMax = Integer.MAX_VALUE;
        for (int j = 0; j <= maxG; j++) {
            for (int index : lists.get(j)) {
                b[index] = false;
            }

            int setMin = -1;
            int setMax = -1;
            for (int i = 0; i < n; i++) {
                if (b[i]) {
                    if (setMin == -1 || i < setMin) {
                        setMin = i;
                    }
                    if (setMax == -1 || i > setMax) {
                        setMax = i;
                    }
                }
            }

            if (setMin == -1) {
                if (j >= 1) {
                    minMax = j;
                    break;
                }
            } else {
                boolean[] seen = new boolean[j + 2];
                for (int i = setMin; i <= setMax; i++) {
                    if (a[i] < seen.length) {
                        seen[a[i]] = true;
                    }
                }
                int mex = 0;
                while (mex < seen.length && seen[mex]) {
                    mex++;
                }
                if (mex <= j) {
                    minMax = j;
                    break;
                }
            }
        }

        if (minMax == Integer.MAX_VALUE) {
            minMax = maxG;
        } else {
            minMax = Math.min(minMax, maxG);
        }

        int max = Arrays.stream(a).max().orElseThrow();
        int maxMax;
        if (n == 1) {
            maxMax = maxG;
        } else {
            maxMax = Math.max(max, maxG);
        }

        int minMin = (n == 1 && a[0] == 0) ? 1 : 0;
        int maxMin = maxG;

        return new int[]{minMax, maxMax, minMin, maxMin};
    }
}
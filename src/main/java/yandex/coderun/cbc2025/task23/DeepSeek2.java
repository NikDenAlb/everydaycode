package yandex.coderun.cbc2025.task23;

import java.util.*;

class DeepSeek2 {
    public int[] calculateAnswer(int n, int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int num : a) {
            set.add(num);
        }
        int maxGMod = 0;
        while (set.contains(maxGMod)) {
            maxGMod++;
        }

        int max = Arrays.stream(a).max().orElseThrow();

        List<List<Integer>> positions = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            positions.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (a[i] <= max) {
                positions.get(a[i]).add(i);
            }
        }

        int[] minIndexArr = new int[max + 1];
        int[] maxIndexArr = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            int minIdx = Integer.MAX_VALUE;
            int maxIdx = -1;
            for (int j = 0; j < n; j++) {
                if (a[j] > i) {
                    if (j < minIdx) {
                        minIdx = j;
                    }
                    if (j > maxIdx) {
                        maxIdx = j;
                    }
                }
            }
            minIndexArr[i] = minIdx;
            maxIndexArr[i] = maxIdx;
        }

        int minMax = maxGMod;
        for (int x = 0; x < maxGMod; x++) {
            if (x > max) {
                break;
            }
            int Lx = minIndexArr[x];
            int Rx = maxIndexArr[x];
            if (Lx == Integer.MAX_VALUE) {
                if (x >= 1) {
                    minMax = x;
                    break;
                } else {
                    continue;
                }
            }
            boolean allPresent = true;
            for (int v = 0; v <= x; v++) {
                List<Integer> list = positions.get(v);
                if (list.isEmpty()) {
                    allPresent = false;
                    break;
                }
                int low = 0;
                int high = list.size() - 1;
                boolean foundInSegment = false;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    int idx = list.get(mid);
                    if (idx < Lx) {
                        low = mid + 1;
                    } else if (idx > Rx) {
                        high = mid - 1;
                    } else {
                        foundInSegment = true;
                        break;
                    }
                }
                if (!foundInSegment) {
                    allPresent = false;
                    break;
                }
            }
            if (!allPresent) {
                minMax = x;
                break;
            }
        }

        int maxMax;
        if (n == 1) {
            maxMax = maxGMod;
        } else {
            maxMax = Math.max(max, maxGMod);
        }

        int minMin;
        if (n == 1 && a[0] == 0) {
            minMin = 1;
        } else {
            minMin = 0;
        }

        int maxMin = maxGMod;

        return new int[]{minMax, maxMax, minMin, maxMin};
    }
}
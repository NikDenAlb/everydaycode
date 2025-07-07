package yandex.coderun.cbc2025.task13;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/binary-forest">task link</a><br>
 * test - OK
 */
class Solution {
    int solve(int n, int[] a, int m, int[] b) {
        List<Pair> listA = inspect(a);
        List<Pair> listB = inspect(b);
        int out = 0;
        for (int i = 0, j = 0; i < listA.size() && j < listB.size(); ) {
            Pair pA = listA.get(i);
            Pair pB = listB.get(j);

            out = Math.max(out, Math.min(pA.num0, pB.num0) + Math.min(pA.num1, pB.num1));

            if (pA.num0 > pB.num0) {
                j++;
            } else {
                i++;
            }
        }
        return out;
    }

    List<Pair> inspect(int[] arr) {
        List<Integer> nums = new ArrayList<>();
        int g = 0;
        int cnt = 0;
        int i = 0;
        while (i < arr.length && arr[i] == 0) {
            i++;
            cnt++;
        }
        nums.add(cnt);
        while (i < arr.length) {
            g = (g + 1) % 2;
            cnt = 0;
            while (i < arr.length && arr[i] == g) {
                i++;
                cnt++;
            }
            nums.add(cnt);
        }
        List<Pair> out = new ArrayList<>();
        cnt = 0;
        int cnt1 = sumOnes(nums, 1);
        for (int j = 0; j < nums.size(); j++) {
            cnt += nums.get(j);
            if (++j < nums.size()) {
                out.add(new Pair(cnt, cnt1));
                cnt1 -= nums.get(j);
            } else {
                out.add(new Pair(cnt, 0));
            }
        }
        return out;
    }

    int sumOnes(List<Integer> list, int idx) {
        int out = 0;
        for (; idx < list.size(); idx += 2) {
            out += list.get(idx);
        }
        return out;
    }

    record Pair(int num0, int num1) {
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(7, new int[]{0, 0, 0, 1, 0, 1, 1}, 6, new int[]{0, 0, 1, 1, 0, 1}));
        //5
    }
}

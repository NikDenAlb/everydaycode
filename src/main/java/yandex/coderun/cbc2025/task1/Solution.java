package yandex.coderun.cbc2025.task1;

/**
 * <a href="https://coderun.yandex.ru/seasons/2025-summer/tracks/common/problem/coderun-welcome">task link</a><br>
 * test - OK
 */
public class Solution {
    public int solve(int n, int m) {
        int min = Math.min(n, m);
        int all;
        if (n == m) {
            all = 2 * min;
        } else {
            all = 2 * min + 1;
        }
        int out = 0;
        while (out * out <= all) {
            out++;
        }
        return --out;
    }
}

/*
[][][][]
[][][][]
[][][][]
[][][][]
*/

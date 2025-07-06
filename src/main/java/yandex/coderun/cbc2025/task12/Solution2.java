package yandex.coderun.cbc2025.task12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Monument of stupidity
 */
public class Solution2 {
    public int[] solve(int n, int k, int[] a) {
        if (n != a[a.length - 1]) {
            int[] temp = new int[a.length + 1];
            System.arraycopy(a, 0, temp, 0, a.length);
            temp[a.length] = n;
            a = temp;
        }
        if (a[0] > 2) {
            return new int[]{-1};
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1] + 2) {
                return new int[]{-1};
            }
        }
        List<Integer> preOut = new ArrayList<>();
        int i = 0, j = 0;
        while (j < a.length - 4) {
            if (a[j] == i + 2) {
                preOut.add(2);
                i += 2;
                j++;
            } else if (a[j + 1] == i + 2 && (a[j + 3] == i + 4 || a[j + 4] == i + 4)) {
                preOut.add(2);
                i += 2;
                j += 2;
            } else {
                preOut.add(1);
                i++;
                j++;
            }
        }

        //(i)[j][][][*]
        if (j == a.length - 4) {
            if (a[j] == i + 2) {
                preOut.add(2);
                i += 2;
                j++;
                //(i)[j][][*]
                if (a[j] == i + 2) {
                    preOut.add(2);
                    i += 2;
                    j++;
                    //(i)[j][*]
                    if (a[j] == i + 2) {
                        preOut.add(2);
                        preOut.add(a[a.length - 1] - a[a.length - 2]);
                    } else { //(i)[+1j][*]
                        if (a[j + 1] == i + 2) {
                            preOut.add(2);
                        } else {
                            preOut.add(1);
                            preOut.add(2);
                        }
                    }
                } else { //(i)[+1j][][*]
                    if (a[j + 1] == i + 3) {
                        preOut.add(1);
                        preOut.add(2);
                        preOut.add(a[a.length - 1] - a[a.length - 2]);
                    } else { //(i)[+1j][+1][*]
                        if (a[j + 2] == i + 3) {
                            preOut.add(1);
                            preOut.add(2);
                        } else {
                            preOut.add(2);
                            preOut.add(2);
                        }
                    }
                }
            } else { //(i)[+1j][][][*]
                if (a[j + 1] == i + 3) {
                    preOut.add(1);
                    preOut.add(2);
                }
            }
        }


        int[] out = new int[preOut.size() + 1];
        out[0] = preOut.size();
        for (int i1 = 1; i1 < out.length; i1++) {
            out[i1] = preOut.get(i1 - 1);
        }
        return out;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.solve(5, 3, new int[]{2, 3, 4})));
        //3, 2, 1, 2
        System.out.println(Arrays.toString(solution.solve(7, 3, new int[]{2, 3, 4})));
        //-1
        System.out.println(Arrays.toString(solution.solve(2, 1, new int[]{1})));
        //1, 2
        System.out.println(Arrays.toString(solution.solve(10, 8, new int[]{2, 3, 4, 5, 6, 7, 8, 9})));
        //5, 2, 2, 2, 2, 2
        System.out.println(Arrays.toString(solution.solve(10, 5, new int[]{1, 3, 5, 7, 9})));
        //6, 1, 2, 2, 2, 2, 1
        System.out.println(Arrays.toString(solution.solve(10, 2, new int[]{5, 10})));
        //-1
        System.out.println("----------------------");
        System.out.println(Arrays.toString(solution.solve(7, 4, new int[]{1, 2, 4, 6})));
        //[4, 2, 2, 2, 1]
        System.out.println("----------------------");
        System.out.println(Arrays.toString(solution.solve(6, 4, new int[]{1, 2, 3, 5})));
        //[4, 1, 2, 2, 1]
        System.out.println("----------------------");
        System.out.println("----------------------");
        System.out.println(Arrays.toString(solution.solve(2, 2, new int[]{1, 2})));
        System.out.println(Arrays.toString(solution.solve(3, 2, new int[]{1, 3})));
        //[2, 1, 2]
        System.out.println(Arrays.toString(solution.solve(2, 1, new int[]{1})));
        //[2, 1, 2]
    }
}


//[*][][1]
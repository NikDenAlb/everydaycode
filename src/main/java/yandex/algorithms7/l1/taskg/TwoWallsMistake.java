package yandex.algorithms7.l1.taskg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/*
               Wall0 has symmetry. we can put bricks from the start likewise from the end
                                      |
 c                                    |
[0]    [0][ ][ ][*][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][ ][*][ ][ ][w0]
[1]    [0][ ][*][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][ ][ ][ ][ ][w0]  -----------
[2]    [0][ ][ ][ ][*][*][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][ ][ ][ ][ ][w0]  \           \    cBs.c[i]
[3]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][ ][ ][ ][ ][w0]   \           [][][][][][][]
[4]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][ ][ ][ ][ ][w0]    \          [][][][][][][] - inner array for
[5]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][ ][ ][ ][ ][w0]      bp[]     [][][][][][][]   answer recovery
[6]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][ ][ ][ ][ ][w0]    /
[7]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][ ][ ][ ][ ][w0]   /
[8]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][ ][ ][ ][ ][w0]  /
...    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][ ][ ][ ][ ][w0]
[k]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][ ][ ][ ][ ][w0]
        0           |                 |                             w0 - length of all bricks of color (original wall)
                    |                midW
                    |
            if all colors have same possible bricks change, we can cut the wall on 2 halves by this index

k[]:  [0][1][2]...[<=49]
num of all colors from 0 to k-1

original length-color bricks:
l[]:  [ ][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]...[      ]
c[]:  [ ][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]...[      ]
       0                                                                                     (n-1)<=4999
 */
public class TwoWallsMistake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] l = new int[n];
        int[] c = new int[n];
        List<List<Integer>> cBs = new ArrayList<>(); //colorBricks - map color-listOfBricks
        for (int i = 0; i < k; i++) {
            cBs.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String[] lc = reader.readLine().split(" ");
            l[i] = Integer.parseInt(lc[0]);
            c[i] = Integer.parseInt(lc[1]) - 1; //to make color == index of k[]
            cBs.get(c[i]).add(l[i]);
        }

        int w0 = cBs.getFirst().stream().mapToInt(Integer::intValue).sum();
        int midW = (w0 + 1) / 2 + 1; //end wall0 index need to calculate, our maxWeight (maxLength) of backpack

        //bp[color][colorBricks.get(color).size][midW(bricks distribution in original wall]
        int[][][] bp = new int[k][][];

        //i - color
        for (int i = 0; i < k; i++) {
            bp[i] = new int[cBs.get(i).size()][midW];
            if (cBs.get(i).getFirst() < midW) {
                bp[i][0][cBs.get(i).getFirst()] = cBs.get(i).getFirst();
            }

        //j - colorBrick, answer recovery row
            for (int j = 1; j < bp[i].length; j++) {
                bp[i][j] = bp[i][j - 1].clone();
        //o - length index, cut point
                for (int o = midW - cBs.get(i).get(j); o >= 0; o--) {
                    if (bp[i][j][o] > 0) {
                        if (bp[i][j][o] + cBs.get(i).get(j) <= midW) {
                            bp[i][j][o] += cBs.get(i).get(j);
                        }
                    }
                }

            }

        }


        reader.close();
        writer.close();
    }
}

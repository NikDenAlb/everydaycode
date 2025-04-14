import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
               Wall0 has symmetry. we can put bricks from the start likewise from the end
                                      |
 c                                    |
[0]    [0][ ][ ][*][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][*][*][ ][ ][w0]         * - index of the brick from cBs[i]
[1]    [0][ ][*][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][*][ ][*][ ][w0]             or -1 if it's can't be cut there
[2]    [0][ ][ ][ ][*][*][ ][ ][ ][ ] | [ ][ ][ ][ ][*][*][ ][ ][ ][w0]  \
[3]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][*][ ][ ][ ][w0]   \
[4]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][*][ ][ ][ ][w0]    \
[5]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][*][ ][ ][ ][w0]      bp[]
[6]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][*][ ][ ][ ][w0]    /
[7]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][*][ ][ ][ ][w0]   /
[8]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][*][ ][ ][ ][w0]  /
...    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][*][ ][ ][ ][w0]
[k]    [0][ ][ ][ ][*][ ][ ][ ][ ][ ] | [ ][ ][ ][ ][ ][*][ ][ ][ ][w0]
        0           |  x              |                             w0 - length of all bricks of color (original wall)
                    |  |             midW
                    |  cutPointIndex
                    |
            if all colors have same possible bricks change, we can cut the wall on 2 halves by this index

k[]:  [0][1][2]...[<=49]
num of all colors from 0 to k-1

original length-color bricks:
l[]:  [ ][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]...[      ]
c[]:  [ ][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]...[      ]
       0                                                                                     (n-1)<=4999
 */
public class TwoWalls {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] l = new int[n];
        int[] c = new int[n];
        List<List<Integer>> cBs = new ArrayList<>(); //colorBricks - color-listOfLength
        List<List<Integer>> cBsIndex = new ArrayList<>(); //map cBs with global index (of c[] and l[])
        for (int i = 0; i < k; i++) {
            cBs.add(new ArrayList<>());
            cBsIndex.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String[] lc = reader.readLine().split(" ");
            l[i] = Integer.parseInt(lc[0]);
            c[i] = Integer.parseInt(lc[1]) - 1; //to make color == index of k[]
            cBs.get(c[i]).add(l[i]);
            cBsIndex.get(c[i]).add(i + 1);
        }

        int w0 = cBs.getFirst().stream().mapToInt(Integer::intValue).sum();
        if (w0 == 1) {
            writer.write("NO");
            reader.close();
            writer.close();
            return;
        }
        int midW = w0 / 2 + 1; //end wall0 index need to calculate, our maxWeight (maxLength) of backpack

        //bp[color][colorBricks.get(color).size][midW(bricks distribution in original wall]
        int[][] bp = new int[k][midW];

        //i - color
        for (int i = 0; i < k; i++) {
            Arrays.fill(bp[i], -1);
            bp[i][0] = 0;

            //j - brick
            for (int j = 0; j < cBs.get(i).size(); j++) {

                //o - length index, cutPoint
                for (int o = bp[i].length - 1 - cBs.get(i).get(j); o >= 0; o--) {
                    if (bp[i][o] > -1 && bp[i][o + cBs.get(i).get(j)] == -1) {
                        bp[i][o + cBs.get(i).get(j)] = j;
                    }
                }
            }
        }

        StringBuilder out = new StringBuilder();
        int index = checkBp(bp);
        if (index == -1) {
            writer.write("NO");
            reader.close();
            writer.close();
            return;
        }
        out.append("YES").append("\n");
        for (int i = 0; i < k; i++) {
            int j = index;
            while (j > 0) {
                out.append(cBsIndex.get(i).get(bp[i][j])).append(" ");
                j -= cBs.get(i).get(bp[i][j]);
            }
        }
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static int checkBp(int[][] bp) {
        for (int i = 1; i < bp[0].length; i++) {
            boolean flag = true;
            for (int[] ints : bp) {
                if (ints[i] == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}

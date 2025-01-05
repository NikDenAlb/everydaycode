package yandex.internship260824backend.taskc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class AltHistory {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] aString = reader.readLine().split(" ");
        String[] bString = reader.readLine().split(" ");
        String[] cString = reader.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(aString[i]);
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(bString[i]);
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(cString[i]);
        }

        reader.close();

        System.out.println(altHistory(n, a, b, c));
    }

    /**
     * @param n количество исторических событий
     * @param a сет событий A
     * @param b множество событий B
     * @param c множество событий C
     * @return минимальное количество лет, информацию о которых необходимо вычеркнуть
     */
    public static int altHistory(int n, int[] a, int[] b, int[] c) {
        HashSet<Integer> aSet = new HashSet<>();
        HashSet<Integer> bSet = new HashSet<>();
        HashSet<Integer> cSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            aSet.add(a[i]);
            bSet.add(b[i]);
            cSet.add(c[i]);
        }

        HashSet<Integer> commonSet = new HashSet<>(aSet);
        commonSet.retainAll(bSet);
        commonSet.retainAll(cSet);
        if (commonSet.size() == n) {
            return 0;
        }

        int nNew = commonSet.size();
        int[] aNew = new int[nNew];
        int[] bNew = new int[nNew];
        int[] cNew = new int[nNew];

        for (int i = 0, j = 0; i < n; i++) {
            if (commonSet.contains(a[i])) {
                aNew[j] = a[i];
                bNew[j] = b[i];
                cNew[j] = c[i];
                j++;
            }
        }
        return n - commonSet.size() + altHistory(nNew, aNew, bNew, cNew);
    }
}

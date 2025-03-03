package yandex.coderun.random.task5205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
4, 15
----
---- ---- ---- ---

---- ---- ---- ---
----

----
---

---
-

-
0
*/

/**
 * <a href="https://coderun.yandex.ru/problem/gcd-and-lcm">task link</a><br>
 * test - OK
 */
public class GcdAndLcm {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);

        int gcd = a;
        int bC = b;
        while (bC != 0) {
            int temp = gcd;
            gcd = bC;
            bC = temp % bC;
        }

        long lcm = (long) a * b / gcd;

        writer.write(gcd + " " + lcm);

        reader.close();
        writer.close();
    }
}

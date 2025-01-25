package yandex.coderun.quickstart.task10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/selections/quickstart/problems/gcd-and-lcm">task link</a><br>
 * test - OK
 */
public class GCDAndLCM {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numsString = reader.readLine().split(" ");
        int a = Integer.parseInt(numsString[0]);
        int b = Integer.parseInt(numsString[1]);

        int gcd = a;
        int b2 = b;
        while (b2 != 0) {
            int temp = b2;
            b2 = gcd % b2;
            gcd = temp;
        }
        long lcm = (long) a / gcd * b;

        writer.write(gcd + " " + lcm);

        reader.close();
        writer.close();
    }
}

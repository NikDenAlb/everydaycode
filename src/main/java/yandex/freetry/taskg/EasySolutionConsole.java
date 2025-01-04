package yandex.freetry.taskg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EasySolutionConsole {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String J = r.readLine();
        String S = r.readLine();
        r.close();

        System.out.println(stoneJewels(J,S));
    }

    public static int stoneJewels(String J, String S) {
        int result = 0;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (J.indexOf(ch) >= 0) {
                ++result;
            }
        }
        return result;
    }
}

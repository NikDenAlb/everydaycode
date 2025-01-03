package yandex.freetry.taskg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class EasySolutionFile {
    public static void main(String[] args) throws Exception {
        String inputFile = "src/main/java/yandex/freetry/taskg/input.txt";
        String outputFile = "src/main/java/yandex/freetry/taskg/output.txt";

        BufferedReader r = new BufferedReader(new FileReader(inputFile));
        String J = r.readLine();
        String S = r.readLine();
        r.close();

        BufferedWriter w = new BufferedWriter(new FileWriter(outputFile));
        w.write(String.valueOf(stoneJewels(J,S)));
        w.close();
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

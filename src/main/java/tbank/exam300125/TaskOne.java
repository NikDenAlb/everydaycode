package tbank.exam300125;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TaskOne {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] sArr = reader.readLine().toCharArray();

        if (sArr[0] == 'R') {
            writer.write("Yes");
        } else if (sArr[1] == 'R' && sArr[2] == 'M') {
            writer.write("Yes");
        } else {
            writer.write("No");
        }

        reader.close();
        writer.close();
    }
}

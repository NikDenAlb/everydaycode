package yandex.algorithms7.l3.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NumberOfOnes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long x = Long.parseLong(reader.readLine());

        int count = 0;
        while (x > 0) {
            x &= (x - 1);
            count++;
        }

        writer.write(String.valueOf(count));

        reader.close();
        writer.close();
    }
}

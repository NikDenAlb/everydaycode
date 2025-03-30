package livecoding.coderun.task82;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/conditioner">task link</a><br>
 * <a href="https://youtu.be/9gT2w-raaTM">video link</a>
 */
public class Conditioner {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int tRoom = Integer.parseInt(input[0]);
        int tCond = Integer.parseInt(input[1]);
        String mode = reader.readLine();

        if (    (mode.equals("heat")    || mode.equals("auto")) && tCond > tRoom ||
                (mode.equals("freeze")  || mode.equals("auto")) && tCond < tRoom) {
            writer.write(String.valueOf(tCond));
        } else {
            writer.write(String.valueOf(tRoom));
        }

        reader.close();
        writer.close();
    }
}

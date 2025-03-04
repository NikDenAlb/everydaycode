package yandex.coderun.random.task82;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/conditioner">task link</a><br>
 * test - OK
 */
public class Conditioner {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = reader.readLine().split(" ");
        int tRoom = Integer.parseInt(nums[0]);
        int tCond = Integer.parseInt(nums[1]);

        String mode = reader.readLine();

        writer.write(String.valueOf(conditionerWork(tRoom, tCond, mode)));

        reader.close();
        writer.close();
    }

    static int conditionerWork(int tRoom, int tCond, String mode) {
        if (    (mode.equals("heat")    || mode.equals("auto")) && tCond > tRoom ||
                (mode.equals("freeze")  || mode.equals("auto")) && tCond < tRoom) {
            return tCond;
        }
        return tRoom;
    }
}

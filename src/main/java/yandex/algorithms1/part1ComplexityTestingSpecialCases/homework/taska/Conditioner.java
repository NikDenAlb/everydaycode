package yandex.algorithms1.part1ComplexityTestingSpecialCases.homework.taska;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * test - Ok
 */
public class Conditioner {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = reader.readLine().split(" ");
        int troom = Integer.parseInt(nums[0]);
        int tcond = Integer.parseInt(nums[1]);

        String mode = reader.readLine();

        reader.close();

        System.out.println(conditionerWork(troom, tcond, mode));
    }

    /**
     * @param tRoom температура комнаты
     * @param tCond целевая температура
     * @param mode  режим работы
     * @return итоговая температура
     */
    public static int conditionerWork(int tRoom, int tCond, String mode) {

        if (((mode.equals("heat") || mode.equals("auto")) && tCond > tRoom)
                || ((mode.equals("freeze") || mode.equals("auto")) && tCond < tRoom)) {
            return tCond;
        }

        return tRoom;
    }
}

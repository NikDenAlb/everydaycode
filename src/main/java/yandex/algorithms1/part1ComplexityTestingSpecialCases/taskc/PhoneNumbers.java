package yandex.algorithms1.part1ComplexityTestingSpecialCases.taskc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * test - Ok
 */
public class PhoneNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String newNumber = reader.readLine();
        String numA = reader.readLine();
        String numB = reader.readLine();
        String numC = reader.readLine();

        reader.close();

        System.out.println(matchesList(newNumber, numA, numB, numC));
    }

    /**
     * @param newNumber номер, добавляемый в телефонную книгу
     * @param numA      первый номер в памяти
     * @param numB      второй номер в памяти
     * @param numC      третий номер в памяти
     * @return список совпадений добавляемого номера с номерами из памяти, разделенный переносами строк.
     */
    public static String matchesList(String newNumber, String numA, String numB, String numC) {
        long newNumberL = numberToLong(newNumber);
        long numAL = numberToLong(numA);
        long numBL = numberToLong(numB);
        long numCL = numberToLong(numC);

        return matcherNumber(newNumberL, numAL) + '\n'
                + matcherNumber(newNumberL, numBL) + '\n'
                + matcherNumber(newNumberL, numCL);
    }

    private static long numberToLong(String number) {
        number = number.replaceAll("[^0-9]", "");

        long out = (Long.parseLong(number));

        if (out < 1_000_00_00) {
            out += 1_000_00_00 * 8495L;
        } else if (number.charAt(0) == '7') {
            out += 10_000_000_000L;
        }

        return out;
    }

    private static String matcherNumber(long newNumber, long oldNumber) {
        return newNumber == oldNumber ? "YES" : "NO";
    }
}

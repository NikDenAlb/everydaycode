package yandex.coderun.random.task80;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/phone-numbers">task link</a><br>
 * test - OK
 */
public class PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String newNumber = reader.readLine();
        String numA = reader.readLine();
        String numB = reader.readLine();
        String numC = reader.readLine();

        writer.write(matchesList(newNumber, numA, numB, numC));

        reader.close();
        writer.close();
    }

    static String matchesList(String newNumber, String numA, String numB, String numC) {
        long newNumberL = numberToLong(newNumber);
        long numAL = numberToLong(numA);
        long numBL = numberToLong(numB);
        long numCL = numberToLong(numC);

        return matcherNumber(newNumberL, numAL) + '\n'
                + matcherNumber(newNumberL, numBL) + '\n'
                + matcherNumber(newNumberL, numCL);
    }

    static long numberToLong(String number) {
        number = number.replaceAll("[^0-9]", "");
        long out = (Long.parseLong(number));
        if (out < 1_000_00_00) {
            out += 1_000_00_00L * 8495;
        } else if (number.charAt(0) == '7') {
            out += 10_000_000_000L;
        }
        return out;
    }

    static String matcherNumber(long newNumber, long oldNumber) {
        return newNumber == oldNumber ? "YES" : "NO";
    }
}

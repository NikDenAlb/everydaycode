package yandex.freetry.taskb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SumTwoNumbers {
    public static void main(String[] args) {
        String inputFileName = "src/main/java/yandex/freetry/taskA/input.txt";
        String outputFileName = "src/main/java/yandex/freetry/taskA/output.txt";

        try {
            BufferedWriter writer = getBufferedWriter(inputFileName, outputFileName);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка в формате числа: " + e.getMessage());
        }
    }

    private static BufferedWriter getBufferedWriter(String inputFileName, String outputFileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        String line = reader.readLine();
        reader.close();

        String[] numbers = line.split(" ");

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
        writer.write(String.valueOf(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1])));
        writer.newLine();
        return writer;
    }
}

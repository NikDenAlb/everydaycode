package yandex.freetry.taskc;

import java.util.Scanner;

public class SumTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(scanner.nextInt()+scanner.nextInt());

        scanner.close();
    }
}

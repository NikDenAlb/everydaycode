package yandex.algorithms1.part2LinearSearch.homework.taska;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * test - OK: 55ms  10.57Mb
 */
public class IsListGrowing {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        reader.close();

        System.out.println(isListGrowing(input));
    }

    /**
     * @param list последовательность на проверку
     * @return "YES" - если на каждом шагу возрастает, иначе "NO"
     */
    public static String isListGrowing(String[] list) {
        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(list[i - 1]) <= 0) {
                return "NO";
            }
        }
        return "YES";
    }
}

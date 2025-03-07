package yandex.coderun.random.task86;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/bank-accounts">task link</a><br>
 * test - OK
 */
public class BankAccounts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        Map<String, Integer> map = new HashMap<>();
        StringBuilder out = new StringBuilder();
        while ((input = reader.readLine()) != null && !input.isEmpty()) {
            String[] command = input.split(" ");
            String output = execute(command, map);
            if (!output.isEmpty()) {
                out.append(output).append("\n");
            }
        }
        out.setLength(out.length() - 1);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static String execute(String[] command, Map<String, Integer> map) {
        switch (command[0]) {
            case "DEPOSIT":
                map.put(command[1], map.getOrDefault(command[1], 0) + Integer.parseInt(command[2]));
                return "";
            case "WITHDRAW":
                map.put(command[1], map.getOrDefault(command[1], 0) - Integer.parseInt(command[2]));
                return "";
            case "BALANCE":
                return map.containsKey(command[1]) ? String.valueOf(map.get(command[1])) : "ERROR";
            case "TRANSFER":
                int sum = Integer.parseInt(command[3]);
                map.put(command[1], map.getOrDefault(command[1], 0) - sum);
                map.put(command[2], map.getOrDefault(command[2], 0) + sum);
                return "";
            case "INCOME":
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    Integer value = entry.getValue();
                    if (value > 0) {
                        entry.setValue(value + value * Integer.parseInt(command[1]) / 100);
                    }
                }
                return "";
        }
        throw new RuntimeException("Unknown command: " + command[0]);
    }
}

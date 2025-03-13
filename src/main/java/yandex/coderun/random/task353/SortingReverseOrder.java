package yandex.coderun.random.task353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.JSONArray;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * <a href="https://coderun.yandex.ru/problem/sorting-reverse-order">task link</a><br>
 * test - OK
 */
public class SortingReverseOrder {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String server = r.readLine();
        String port = r.readLine();
        String a = r.readLine();
        String b = r.readLine();

        URL yahoo = new URL(server + ":" + port + "/?" + "a=" + a + "&b=" + b);
        ArrayList<Integer> numbers = getIntegers(yahoo);

        Collections.sort(numbers);
        Collections.reverse(numbers);

        for (Integer n : numbers) {
            System.out.println(n);
        }
    }

    private static ArrayList<Integer> getIntegers(URL yahoo) throws IOException, ParseException {
        URLConnection yc = yahoo.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

        ArrayList<Integer> numbers = new ArrayList<>();

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(in);
        for (Object o : jsonArray) {
            int value = ((Long) o).intValue();
            if (value > 0) {
                numbers.add(value);
            }
        }
        return numbers;
    }
}

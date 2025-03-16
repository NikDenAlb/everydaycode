package yandex.coderun.random.task349;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * <a href="https://coderun.yandex.ru/problem/merge-jsons-2">task link</a><br>
 * test - OK
 */
public class MergeJsons2 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        JSONObject allRows = new JSONObject();
        JSONArray offersArray = new JSONArray();
        allRows.put("offers", offersArray);

        JSONParser parser = new JSONParser();

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            JSONObject feed = (JSONObject) parser.parse(line);
            JSONArray offersFromFeed = (JSONArray) feed.get("offers");
            offersArray.addAll(offersFromFeed);
        }

        if (offersArray.size() > m) {
            JSONArray limitedOffersArray = new JSONArray();
            for (int i = 0; i < m; i++) {
                limitedOffersArray.add(offersArray.get(i));
            }
            allRows.put("offers", limitedOffersArray);
        }

        writer.write(allRows.toJSONString());

        reader.close();
        writer.close();
    }
}

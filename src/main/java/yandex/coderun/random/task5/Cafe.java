package yandex.coderun.random.task5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://coderun.yandex.ru/problem/cafe">task link</a><br>
 * test - OK
 */
public class Cafe {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] pays = new int[n];
        for (int i = 0; i < pays.length; i++) {
            pays[i] = Integer.parseInt(reader.readLine());
        }
/*
             key                value
        [CurrCoupons] - [totalPay][dayCouponUsed][dayCouponUsed][dayCouponUsed]...
*/
        Map.Entry<Integer, List<Integer>> ans = calcAns(pays);

        StringBuilder out = new StringBuilder();
        out.append(ans.getValue().getFirst()).append('\n');
        out.append(ans.getKey()).append(' ').append(ans.getValue().size() - 1).append('\n');
        ans.getValue().stream().skip(1).forEach(e -> out.append(e).append('\n'));
        out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static Map.Entry<Integer, List<Integer>> calcAns(int[] pays) {
        if (pays.length == 0) {
            return Map.entry(0, List.of(0));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        if (pays[0] > 100) {
            map.put(1, new ArrayList<>(List.of(pays[0])));
        } else {
            map.put(0, new ArrayList<>(List.of(pays[0])));
        }

        for (int i = 1; i < pays.length; i++) {
            Map<Integer, List<Integer>> newMap = new HashMap<>();
            int iF = i;
            if (pays[i] > 100) {
                map.forEach((key, value) -> {
                    List<Integer> list = new ArrayList<>(value);
                    int pay = list.getFirst();

                    list.set(0, pay + pays[iF]);
                    newMap.put(key + 1, getArray(list, newMap, key + 1));

                    if (key > 0) {
                        list.set(0, pay);
                        list.add(iF + 1);
                        newMap.put(key - 1, getArray(list, newMap, key - 1));
                    }
                });
            } else {
                map.forEach((key, value) -> {
                    List<Integer> list = new ArrayList<>(value);
                    int pay = list.getFirst();

                    list.set(0, pay + pays[iF]);
                    newMap.put(key, getArray(list, newMap, key));

                    if (key > 0) {
                        list.set(0, pay);
                        list.add(iF + 1);
                        newMap.put(key - 1, getArray(list, newMap, key - 1));
                    }
                });
            }
            map = newMap;
        }

        int minTotalPay = map.values().stream().map(List::getFirst).min(Integer::compareTo).orElseThrow();
        return map.entrySet().stream()
                .filter(e -> e.getValue().getFirst().equals(minTotalPay))
                .max(Map.Entry.comparingByKey()).orElseThrow();
    }

    static List<Integer> getArray(List<Integer> newList, Map<Integer, List<Integer>> map, int key) {
        if (!map.containsKey(key)) {
            return new ArrayList<>(newList);
        }
        if (newList.getFirst() < map.get(key).getFirst()) {
            return new ArrayList<>(newList);
        } else {
            return new ArrayList<>(map.get(key));
        }
    }
}

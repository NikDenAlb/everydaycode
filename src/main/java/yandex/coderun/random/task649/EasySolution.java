package yandex.coderun.random.task649;

import java.util.ArrayDeque;
import java.util.Queue;

class EasySolution {
    String predictPartyVictory(String senate) {
        Queue<Boolean> queue = new ArrayDeque<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                queue.add(true);
            } else {
                queue.add(false);
            }
        }
        int ban = 0;
        while (true) {
            boolean s = queue.poll();
            if (queue.isEmpty()) {
                return s ? "Radiant" : "Dire";
            }
            if (s && ban >= 0) {
                ban++;
                if (ban >= queue.size()) {
                    return "Radiant";
                }
                queue.add(s);
            } else if (!s && ban <= 0) {
                ban--;
                if (-ban >= queue.size()) {
                    return "Dire";
                }
                queue.add(s);
            } else if (s) {
                ban++;
            } else {
                ban--;
            }
        }
    }
}

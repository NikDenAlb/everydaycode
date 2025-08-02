package yandex.algorithms7.l4.taskb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ErrorProofQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        MyQueue queue = new MyQueue();
        StringBuilder out = new StringBuilder();
        String line;
        while (!(line = reader.readLine()).equals("exit")) {
            String[] cmd = line.split(" ");
            out.append(execute(queue, cmd)).append("\n");
        }
        out.append("bye");

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static String execute(MyQueue queue, String[] cmd) {
        return switch (cmd[0]) {
            case "push" -> queue.push(Integer.parseInt(cmd[1]));
            case "pop" -> queue.pop();
            case "front" -> queue.front();
            case "size" -> queue.size();
            case "clear" -> queue.clear();
            default -> throw new IllegalStateException();
        };
    }
}

/**
 * Очередь (queue) — это структура данных, которая работает по принципу FIFO. Мой класс моделирует работу очереди,
 * реализовывая её основные методы.
 */
class MyQueue {
    int size = 0;
    Node firstNode;
    Node lastNode;

    public MyQueue() {
    }

    /**
     * Добавляет в очередь новое значение
     *
     * @return "ok"
     */
    public String push(int value) {
        Node newNode = new Node(value);
        if (size++ == 0) {
            firstNode = newNode;
            lastNode = newNode;
            return "ok";
        }
        newNode.left = lastNode;
        lastNode.right = newNode;
        lastNode = newNode;

        return "ok";
    }

    /**
     * Удаляет первый элемент и выводит его значение.
     *
     * @return String firstValue
     */
    public String pop() {
        if (size == 0) {
            return "error";
        }
        String out = String.valueOf(firstNode.value);
        firstNode = firstNode.right;
        size--;

        return out;
    }

    /**
     * Выводит значение первого элемента очереди
     *
     * @return String firstValue
     */
    public String front() {
        if (size == 0) {
            return "error";
        }
        return String.valueOf(firstNode.value);
    }

    /**
     * Выводит количество элементов в очереди
     *
     * @return String size
     */
    public String size() {
        return String.valueOf(size);
    }

    /**
     * Очищает очередь
     *
     * @return "ok"
     */
    public String clear() {
        size = 0;
        lastNode = null;
        firstNode = null;

        return "ok";
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

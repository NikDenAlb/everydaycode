package yandex.algorithms7.l4.taskc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ErrorProofDeque {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        MyDeque deque = new MyDeque();
        StringBuilder out = new StringBuilder();
        String line;
        while (!(line = reader.readLine()).equals("exit")) {
            String[] cmd = line.split(" ");
            out.append(execute(deque, cmd)).append("\n");
        }
        out.append("bye");

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static String execute(MyDeque deque, String[] cmd) {
        return switch (cmd[0]) {
            case "push_front" -> deque.pushFront(Integer.parseInt(cmd[1]));
            case "push_back" -> deque.pushBack(Integer.parseInt(cmd[1]));
            case "pop_front" -> deque.popFront();
            case "pop_back" -> deque.popBack();
            case "front" -> deque.front();
            case "back" -> deque.back();
            case "size" -> deque.size();
            case "clear" -> deque.clear();
            default -> throw new IllegalStateException();
        };
    }
}

class MyDeque {
    int size = 0;
    Node firstNode;
    Node lastNode;

    /**
     * Добавляет начало дека новый элемент
     *
     * @return "ok"
     */
    public String pushFront(int value) {
        Node newNode = new Node(value);
        if (size++ == 0) {
            firstNode = newNode;
            lastNode = newNode;
            return "ok";
        }
        newNode.right = firstNode;
        firstNode.left = newNode;
        firstNode = newNode;

        return "ok";
    }

    /**
     * Добавляет конец дека новый элемент
     *
     * @return "ok"
     */
    public String pushBack(int value) {
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
    public String popFront() {
        if (size == 0) {
            return "error";
        }
        String out = String.valueOf(firstNode.value);
        firstNode = firstNode.right;
        size--;

        return out;
    }

    /**
     * Удаляет последний элемент и выводит его значение.
     *
     * @return String lastValue
     */
    public String popBack() {
        if (size == 0) {
            return "error";
        }
        String out = String.valueOf(lastNode.value);
        lastNode = lastNode.left;
        size--;

        return out;
    }

    /**
     * Выводит значение первого элемента
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
     * Выводит значение последнего элемента
     *
     * @return String lastValue
     */
    public String back() {
        if (size == 0) {
            return "error";
        }
        return String.valueOf(lastNode.value);
    }

    /**
     * Выводит количество элементов
     *
     * @return String size
     */
    public String size() {
        return String.valueOf(size);
    }

    /**
     * Очищает деку
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ErrorProofStack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        MyStack stack = new MyStack();
        StringBuilder out = new StringBuilder();
        String line;
        while (!(line = reader.readLine()).equals("exit")) {
            String[] cmd = line.split(" ");
            out.append(execute(stack, cmd)).append("\n");
        }
        out.append("bye");

        writer.write(out.toString());

        reader.close();
        writer.close();
    }

    static String execute(MyStack stack, String[] cmd) {
        return switch (cmd[0]) {
            case "push" -> stack.push(Integer.parseInt(cmd[1]));
            case "pop" -> stack.pop();
            case "back" -> stack.back();
            case "size" -> stack.size();
            case "clear" -> stack.clear();
            default -> throw new IllegalStateException();
        };
    }
}

/**
 * Стек (stack) — это структура данных, которая работает по принципу LIFO. Мой класс моделирует работу стека,
 * реализовывая его основные методы.
 */
class MyStack {
    int size = 0;
    Node lastNode;

    public MyStack() {
    }

    /**
     * Добавляет в стек новое значение
     *
     * @return "ok"
     */
    public String push(int value) {
        Node newNode = new Node(value);
        size++;
        newNode.left = lastNode;
        lastNode = newNode;
        return "ok";
    }

    /**
     * Удаляет последний элемент и выводит его значение.
     *
     * @return String lastValue
     */
    public String pop() {
        if (size == 0) {
            return "error";
        }
        String out = String.valueOf(lastNode.value);
        lastNode = lastNode.left;
        size--;

        return out;
    }

    /**
     * Выводит значение последнего элемента стека
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
     * Выводит количество элементов в стеке
     *
     * @return String size
     */
    public String size() {
        return String.valueOf(size);
    }

    /**
     * Очищает стек
     *
     * @return "ok"
     */
    public String clear() {
        size = 0;
        lastNode = null;

        return "ok";
    }
}

class Node {
    int value;
    Node left;

    public Node(int value) {
        this.value = value;
    }
}

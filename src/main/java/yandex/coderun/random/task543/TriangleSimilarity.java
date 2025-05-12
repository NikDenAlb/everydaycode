package yandex.coderun.random.task543;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://coderun.yandex.ru/problem/triangle-similarity">task link</a><br>
 * test - OK
 */
public class TriangleSimilarity {
    static Set<Triangle> triangles = new HashSet<>();

    public static void main(String[] args) throws IOException {
        Reader s = new Reader();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            triangles.add(new Triangle(a, b, c));
        }

        writer.write(String.valueOf(triangles.size()));

        writer.close();
    }

    static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        // Reads the next integer from input
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        // Reads the next byte from the buffer
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        // Fills the buffer with new data
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
    }
}

record Triangle(int a, int b, int c) {
    Triangle(int a, int b, int c) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        if (b > c) {
            int t = b;
            b = c;
            c = t;
        }
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }

        int g = gcd(a, gcd(b, c));
        this.a = a / g;
        this.b = b / g;
        this.c = c / g;
    }

    int gcd(int x, int y) {
        while (y != 0) {
            int t = y;
            y = x % y;
            x = t;
        }
        return x;
    }
}


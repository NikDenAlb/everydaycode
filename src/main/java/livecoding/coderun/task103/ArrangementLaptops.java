package livecoding.coderun.task103;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
    a1
-------------
|           |
|           | b1
|           |
-------------

+++++++++
+       + b2
+++++++++
    a2
*/
public class ArrangementLaptops {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int a1 = Integer.parseInt(line[0]);
        int b1 = Integer.parseInt(line[1]);
        int a2 = Integer.parseInt(line[2]);
        int b2 = Integer.parseInt(line[3]);

        int s1 = Math.max(a1, a2) * (b1 + b2);
        int s2 = Math.max(a1, b2) * (a2 + b1);
        int s3 = Math.max(b1, a2) * (b2 + a1);
        int s4 = Math.max(b1, b2) * (a1 + a2);

        int s = Math.min(Math.min(Math.min(
                                s1,
                                s2),
                                s3),
                                s4);

        if (s == s1) {
            writer.write(Math.max(a1, a2) + " " + (b1 + b2));
        } else if (s == s2) {
            writer.write(Math.max(a1, b2) + " " + (a2 + b1));
        } else if (s == s3) {
            writer.write(Math.max(b1, a2) + " " + (b2 + a1));
        } else {
            writer.write(Math.max(b1, b2) + " " + (a1 + a2));
        }

        reader.close();
        writer.close();
    }
}

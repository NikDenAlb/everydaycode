import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PointsOnPlane {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] xy = reader.readLine().split(" ");
        int x1 = Integer.parseInt(xy[0]);
        int y1 = Integer.parseInt(xy[1]);

        String[] xc = reader.readLine().split(" ");
        int x2 = Integer.parseInt(xc[0]);
        int c2 = Integer.parseInt(xc[1]);

        int c1 = x1 ^ y1;
        int y2 = c2 ^ x2;

        writer.write(c1 + "\n" + y2);

        reader.close();
        writer.close();
    }
}

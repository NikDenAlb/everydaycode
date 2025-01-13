package yandex.algorithms1.taskj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//(f-cx)/d = (e-ax)/b
//b(f-cx) = d (e-ax)
//(da-cb)x=de-bf

//(e-by)/a = (f-dy)/c
//c(e-by)= a (f-dy)
public class TwoLinearEquations {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double a = Double.parseDouble(reader.readLine());
        double b = Double.parseDouble(reader.readLine());
        double c = Double.parseDouble(reader.readLine());
        double d = Double.parseDouble(reader.readLine());
        double e = Double.parseDouble(reader.readLine());
        double f = Double.parseDouble(reader.readLine());

        reader.close();

        System.out.println(solveTwoLinearEquations(a, b, c, d, e, f));
    }
    /**
     * ax+by=e<br>
     * cx+dy=f
     */
    public static String solveTwoLinearEquations(double a, double b, double c, double d, double e, double f) {
        if (a == 0 && b == 0 && c == 0 && d == 0 && e == 0 && f == 0) {
            return "5";
        }

        if (a == c && a == 0 && e / b == f / d) {
            double y = e / b;
            return "4 " + y;
        }

        if (b == d && b == 0 && e / a == f / c) {
            double x = e / a;
            return "3 " + x;
        }

        if (a / c == b / d && a / c != e / f) {
            return "0";
        }

        if (a / c == b / d && a / c == e / f) {
            //y=kx+k2
            //y=-a/bx+e/b
            double k1 = -a / b;
            double k2 = e / b;
            return "1 " + k1 + " " + k2;
        }

        if (a / c != c / d) {
            double x = (d * e - b * f) / (d * a - c * b);
            double y = (a * f - c * e) / (a * d - c * b);
            return "2 " + x + " " + y;
        }

        return "smth wrong, must not be here";
    }
}


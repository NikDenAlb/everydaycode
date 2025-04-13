import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Internet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(reader.readLine());
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //Массив со значениями максимального времени, которое можно купить за стоимость каждой карточки
        int[] pP = new int[31];
        pP[0] = a[0];

    /*
        Если найдётся индекс X, при котором за стоимость следующей по цене карточки, можно купить нужное время
        карточками в интервале [0, X], то заполнять массив дальше нет необходимости.
    */
        int index = 0;
        while (pP[index] << 1 < m && index < pP.length - 1) {
            index++;
            pP[index] = Math.max(pP[index - 1] << 1, a[index]);
        }

        int out = 0;
        do {
        /*
            На индексе 0 возможный остаток от деления нужно будет закрыть ещё одной карточкой 0. Сам же
            результат деления на pP[0] может быть либо 0, либо 1. Другие варианты невозможны, так как большее значение
            привело бы к старшему индексу.
        */
            if (index == 0) {
                out += m > pP[index] ? 2 : 1;
                break;
            }
            //Максимально эффективно складываем суммы для времени, кратного pP[index]. Затем отбрасываем целую часть
            out += (m / pP[index]) << index;
            m %= pP[index];
            //Смотрим, нужно ли разбивать остаток младшими индексами или же выгоднее взять ещё одну pP[index]
            if (m >= pP[index - 1] << 1) {
                out += 1 << index;
                break;
            }
            index--;
        }
        while (m > 0);

        writer.write(String.valueOf(out));

        reader.close();
        writer.close();
    }
}

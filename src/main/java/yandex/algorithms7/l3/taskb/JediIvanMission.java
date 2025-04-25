import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class JediIvanMission {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] m = new int[n][/*n*/];
        for (int i = 0; i < n; i++) {
            m[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] |= m[i][j];
            }
            for (int j = i + 1; j < n; j++) {
                nums[i] |= m[i][j];
            }
        }

        writer.write(Arrays.stream(nums).boxed().map(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}

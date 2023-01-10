import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        Integer[][] xy = new Integer[T][2];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(xy, ((x, y) -> {
            if ((int)x[0] != (int)y[0]) {
                return x[0] - y[0];
            } else {
                return x[1] - y[1];
            }
        }));

        for (Integer[] itemA : xy) {
            bw.write(itemA[0] + " " + itemA[1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

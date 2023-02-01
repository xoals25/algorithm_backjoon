import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[T + 1][T + 1];

        for (int i = 1; i < T + 1; i++) {
            for (int j = 1; j < T + 1; j++) {
                if (i == j) {
                    continue;
                }
                arr[i][j] = INF;
            }
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (i == -1 || j == -1) {
                break;
            }

            arr[i][j] = arr[j][i] = 1;
        }

        for(int k = 1; k <= T; k++) {
            for (int i = 1; i <= T; i++) {
                for (int j = 1; j <= T; j++) {
                    if (arr[i][k] != INF && arr[k][j] != INF) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }

        int[] scores = new int[T + 1];
        int minCount = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 1; i<=T; i++) {
            for(int j = 1; j<=T; j++) {
                scores[i] = Math.max(scores[i], arr[i][j]);
            }
            if (min == scores[i]) {
                minCount++;
            } else if (min > scores[i]) {
                min = scores[i];
                minCount = 1;
            }
        }
        bw.write(min + " " + minCount + "\n");

        for (int i = 1; i <= T; i++) {
            if (min == scores[i]) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
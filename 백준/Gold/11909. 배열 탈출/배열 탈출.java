import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int T;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());


        int[][] arr = new int[T][T];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < T; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[T][T];
        dp[0][0] = 0;

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                int num = Integer.MAX_VALUE;

                if (i == 0 && j == 0) {
                    num = 0;
                } else if (i == 0) {
                    num = arr[i][j - 1] > arr[i][j] ? 0 : arr[i][j] - arr[i][j - 1] + 1;
                    num += dp[i][j - 1];
                } else if (j == 0) {
                    num = arr[i - 1][j] > arr[i][j] ? 0 : arr[i][j] - arr[i - 1][j] + 1;
                    num += dp[i - 1][j];
                } else {
                    int topToBottom = arr[i - 1][j] > arr[i][j] ? 0 : arr[i][j] - arr[i - 1][j] + 1;
                    int leftToRight = arr[i][j - 1] > arr[i][j] ? 0 : arr[i][j] - arr[i][j - 1] + 1;
                    num = Math.min(dp[i - 1][j] + topToBottom, dp[i][j - 1] + leftToRight);
                }

                dp[i][j] = num;
            }
        }

        bw.write(dp[T - 1][T - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
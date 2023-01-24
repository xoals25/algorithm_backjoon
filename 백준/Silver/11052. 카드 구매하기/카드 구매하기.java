import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[T + 1][T + 1];
        dp[1][1] = arr[1];

        for (int i = 2; i <= T; i ++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[j][j] + dp[i - j][i - j]);
                dp[i][j] = Math.max(dp[i][j], arr[j]);
            }
        }

        bw.write(dp[T][T] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

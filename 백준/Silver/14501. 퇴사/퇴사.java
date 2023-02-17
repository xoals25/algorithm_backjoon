import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());


        int[][] arr = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[20];

        for (int i = N; i >= 1; i--) {
            if (i + arr[i][0] > N + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(arr[i][1] + dp[i + arr[i][0]], dp[i + 1]);
            }
        }

        bw.write(dp[1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

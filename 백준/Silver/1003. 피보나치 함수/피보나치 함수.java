import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];
        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};

        for (int i = 2; i <= 40; i++) {
            int[] dp1 = dp[i - 1];
            int[] dp2 = dp[i - 2];
            dp[i][0] = dp1[0] + dp2[0];
            dp[i][1] = dp1[1] + dp2[1];
        }
        
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(dp[num][0] + " " + dp[num][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}


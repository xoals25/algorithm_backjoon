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
        long[][] dp = new long[T + 1][2];
        
        dp[1][0] = 1;
        dp[1][1] = 1;
        
        for (int i = 2; i <= T; i++) {
            dp[i][1] = dp[i - 1][0];
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
        }
        
        bw.write(dp[T][1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
 
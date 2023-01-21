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
        int[] dp = new int[T + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= T; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10_007;
        }
        
        bw.write(dp[T] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}


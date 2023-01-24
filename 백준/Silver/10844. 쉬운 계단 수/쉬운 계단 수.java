import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[T + 1][10];
        long devide = 1_000_000_000;
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        
        for (int i = 2; i <= T; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j <= 9; j++) {
               if (j == 9) {
                    dp[i][j] = (dp[i - 1][j - 1]) % devide;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] % devide + dp[i - 1][j + 1] % devide) % devide;
                }
            }
        }
        
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + dp[T][i]) % devide;
        }
        
      
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

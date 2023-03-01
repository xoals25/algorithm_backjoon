import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1 + 3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 0;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 1) % 2;
        }
        
        System.out.println(dp[n] == 0 ? "SK" : "CY");
        br.close();
    }
}
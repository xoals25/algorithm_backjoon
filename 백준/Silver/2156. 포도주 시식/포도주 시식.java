import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T + 2];
        int[] dp = new int[T + 2];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
        dp[2] = Math.max(dp[2], dp[1]);
        
        int max = Math.max(dp[1], dp[2]);
        
        for (int i = 3; i < T; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

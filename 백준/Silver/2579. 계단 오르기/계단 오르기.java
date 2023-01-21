import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] points = new int[T + 2];
        int[] dp = new int[T + 2];
        
        for (int i = 0; i < T; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }
        
        dp[0] = points[0];
        dp[1] = points[0] + points[1];
        dp[2] = Math.max(points[0] + points[2], points[1] + points[2]);
        for (int i = 3; i < T; i++) {
            dp[i] = Math.max(dp[i - 2] + points[i], dp[i - 3] + points[i - 1] + points[i]);
        }
        
        bw.write(dp[T - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}


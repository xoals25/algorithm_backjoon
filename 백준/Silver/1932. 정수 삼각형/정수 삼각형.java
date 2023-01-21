import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[T][T];
        dp[0][0] = Integer.parseInt(br.readLine());
        int max = dp[0][0];
        
        for (int i = 1; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            
            while (st.hasMoreElements()) {
                int v = Integer.parseInt(st.nextToken());
                dp[i][idx] = idx == 0 ? dp[i - 1][idx] + v : Math.max(dp[i -1][idx - 1], dp[i - 1][idx]) + v;
                
                max = Math.max(max, dp[i][idx]);
                idx++;
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double[] dp = new double[N];

        dp[0] = Double.parseDouble(br.readLine());

        double max = dp[0];

        for (int i = 1; i < N; i++) {
            double num1 = Double.parseDouble(br.readLine());
            double num2 = dp[i - 1] * num1;
            dp[i] = Math.max(num1, num2);
            max = Math.max(max, dp[i]);
        }

        System.out.printf("%.3f\n", max);
        br.close();
    }
}
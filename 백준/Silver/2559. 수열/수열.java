import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[T];
        
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int p = 0;
        int q = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while (q <= T) {
            if (q - p == K) {
                maxSum = Math.max(maxSum, sum);
                
                if (q == T) {
                    break;
                }
                
                sum += arr[q++];
                sum -= arr[p++];
            } else if (q - p < K) {
                sum += arr[q++];
            }
        }
        
        bw.write(maxSum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
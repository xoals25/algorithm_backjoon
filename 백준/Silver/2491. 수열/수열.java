import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxCount = 1;
        int prev = arr[0];
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (prev <= arr[i]) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 1;
            }
            
            prev = arr[i];
        }
        
        prev = arr[N - 1];
        count = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (prev <= arr[i]) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 1;
            }
            
            prev = arr[i];
        }
        
        System.out.println(maxCount);
        br.close();
    }
}
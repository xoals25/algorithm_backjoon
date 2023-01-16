import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int needSum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[T];
        
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = T - 1;
        int count = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (sum == needSum) {
                count++;
                left++;
            } else if (sum < needSum) {
                left++;
            } else {
                right--;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
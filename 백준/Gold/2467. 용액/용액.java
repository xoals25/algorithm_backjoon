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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int [T];
        
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = T - 1;
        int[] answers = new int[2];
        int zeroSum = Integer.MAX_VALUE;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            
           if (zeroSum > Math.abs(sum)) {
                zeroSum = Math.abs(sum);
                answers[0] = arr[left];
                answers[1] = arr[right];
               
                if (sum == 0) {
                    break;
                }
            }
            
            if (Math.abs(arr[left]) <= Math.abs(arr[right])) {
                right--;
            } else {
                left++;
            }
        }
        
        bw.write(answers[0] + " " + answers[1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
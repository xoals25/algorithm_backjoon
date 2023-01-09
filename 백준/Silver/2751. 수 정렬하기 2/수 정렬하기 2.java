import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2_000_001];
        
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine()) + 1_000_000]++;
        }
        
         StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i<arr.length; i++){
            if(arr[i] != 0){
                sb.append(i-1000000).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
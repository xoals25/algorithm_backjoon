import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2_000_001];
        
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine()) + 1_000_000]++;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                bw.write(i - 1_000_000 + "\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2_000_001];
        
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine()) + 1_000_000]++;
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                bw.write(i - 1_000_000 + "\n"); 
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
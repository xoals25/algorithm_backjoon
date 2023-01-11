import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        int[] arr = new int[T];
        
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);

        int max = 0;
        
        for (int i = T; i > 0; i--) {
            if (arr[T - i] * i > max) {
                max = arr[T - i] * i;
            }
        }
        
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
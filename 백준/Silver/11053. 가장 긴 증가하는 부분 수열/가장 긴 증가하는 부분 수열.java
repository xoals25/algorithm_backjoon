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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] arr = new int[T];
        int[] lengths = new int[T + 1];
        
        int maxLength = 0;
        
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            
            lengths[i + 1] = 1;
            
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lengths[i + 1] = Math.max(lengths[i+1], lengths[j + 1] + 1);
                }
            }
            maxLength = Math.max(maxLength, lengths[i + 1]);
        }
        
        bw.write(maxLength + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
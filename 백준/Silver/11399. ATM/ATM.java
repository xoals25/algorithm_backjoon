import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int result = 0;
        int beforeV = 0;
        
        int[] arr = new int[1_001];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < T; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                beforeV = beforeV + i;
                result += beforeV;
            }
        }
        
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

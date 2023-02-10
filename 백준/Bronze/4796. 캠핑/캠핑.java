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
        
        int idx = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            
            if (L == 0) {
                break;
            }
            
            int useDay = V / P * L;
            
            if (V % P >= L) {
                useDay += L;
            } else {
                useDay += V % P;
            }
            
            bw.write("Case " + idx++ + ": " + useDay + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
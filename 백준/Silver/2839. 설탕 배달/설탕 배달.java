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
        int count = 0;
        
        while (T > 0) {
            if (T % 5 == 0) {
                count += T / 5;
                T %= 5;
                break;
            }
            
            T -= 3;
            count++;
        }
        
        count = T == 0 ? count : -1;
        
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        HashSet<String> set1 = new HashSet<>();
        for (int i = 0; i < T; i++) {
            set1.add(st.nextToken());
        }
        
        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < T; i++) {
            if (set1.contains(st.nextToken())) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
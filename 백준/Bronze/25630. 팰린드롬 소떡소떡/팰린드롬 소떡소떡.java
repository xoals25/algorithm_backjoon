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
        String s = br.readLine();
        
        int cnt = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            cnt += s.charAt(i) != s.charAt(s.length() - 1 - i) ? 1 : 0;
        }
        
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        int sCount = 0;
        int tCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) == 's') {
                sCount++;
            } else if (s.charAt(i) == 't') {
                tCount++;
            }
        }
        
        for (int i = 0; i < s.length(); i++) {            
            if (sCount == tCount) {
                bw.write(s.substring(i) + "\n");
                break;
            }
            
            if (s.charAt(i) == 's') {
                sCount--;
            } else if (s.charAt(i) == 't') {
                tCount--;
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
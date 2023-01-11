import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String T = br.readLine();
        
        int count = 0;
        boolean isZero = false;
        
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '0') {
                if (!isZero) {
                    count++;
                }
                isZero = true;
            } else {
                isZero = false;
            }
        }
        
        int count2 = 0;
        boolean isOne = false;
        
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '1') {
                if (!isOne) {
                    count2++;
                }
                isOne = true;
            } else {
                isOne = false;
            }
        }
        
        bw.write((int)Math.min(count, count2) + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
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
        String[] sArr = new String[T];
        
        for (int i = 0; i < T; i++) {
            sArr[i] = br.readLine();
        }
        
        for (int i = 0; i < sArr.length; i++) {
            int left = 0;
            int right = sArr[i].length() - 1;
            
            int count = 0;
            
            while (left < right) {
                if (sArr[i].charAt(left) != sArr[i].charAt(right)) {
                    if (!reCheck(sArr[i], left + 1, right) && !reCheck(sArr[i], left, right - 1)) {
                        count = 2;
                    } else {
                        count = 1;
                    }
                    
                    break;
                }

                left++;
                right--;
            }
            
            bw.write(count + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean reCheck(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}
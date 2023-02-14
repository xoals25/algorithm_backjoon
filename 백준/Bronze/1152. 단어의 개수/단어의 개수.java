import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int count = 0;
        
        boolean isPrevStr = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && !isPrevStr) {
                isPrevStr = true;
                count++;
            } else if (s.charAt(i) == ' ') {
                isPrevStr = false;
            }
        }
        
        System.out.println(count);
        br.close();
    }
}
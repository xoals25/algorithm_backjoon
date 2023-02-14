import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        for (int i = 0; i < s.length(); i += 10) {
            if (i + 10 >= s.length()) {
                System.out.println(s.substring(i));  
            } else {
                System.out.println(s.substring(i, i + 10));  
            }
        }

        br.close();
    }
}
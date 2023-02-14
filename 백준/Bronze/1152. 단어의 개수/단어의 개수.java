import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        
        if (s.equals("")) {
            System.out.println(0);
            return;
        }
        
        int count = s.split(" ").length;
        System.out.println(count);
        br.close();
    }
}
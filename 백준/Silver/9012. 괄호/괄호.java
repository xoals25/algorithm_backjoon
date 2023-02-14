import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();

            boolean ck = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                } else if (stack.isEmpty()) {
                    ck = false;
                    break;
                } else {
                    stack.pop();
                }
            }

            System.out.println(ck && stack.isEmpty() ? "YES" :  "NO");
        }

        br.close();
    }
}
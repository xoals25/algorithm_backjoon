import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String s = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        
        int minusCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            while(!stack.isEmpty() && minusCnt < K && stack.peek() < s.charAt(i)) {
                stack.pop();
                minusCnt++;
            }
            
            stack.add(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N - K; i++) {
            sb.append(stack.get(i));
        }
        
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
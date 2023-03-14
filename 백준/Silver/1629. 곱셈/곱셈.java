import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A;
    static int B;
    static int C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        System.out.println(calc(A, B));
        
        br.close();
    }
    
    public static long calc(int a, int b) {
        if (b == 0) {
            return 1;
        }
        
        long value = calc(a, b / 2);
        
        if (b % 2 == 0) {
            return value * value % C;
        } else {
            return (value * value % C) * a % C;
        }
    }
}
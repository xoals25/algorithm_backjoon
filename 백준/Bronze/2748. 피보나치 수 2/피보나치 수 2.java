import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[] fiboArr = new long[T + 1];
        fiboArr[0] = 1;
        fiboArr[1] = 1;
        
        if (T == 0 || T == 1) {
            int count = T == 0 ? 0 : 1;
            bw.write(count + "\n");
        } else {
            bw.write(fibonacci(fiboArr, T) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static long fibonacci(long[] fiboArr, int T) {
        if (T == 0) {
            return 0;
        }
        
        if (fiboArr[T] == 0) {
            return fiboArr[T] = fibonacci(fiboArr, T - 1) + fibonacci(fiboArr, T - 2);
        } else {
            return fiboArr[T];
        }
    }
}
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int max = Integer.MIN_VALUE;
        int nowSum = 0;
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(st.nextToken());
            nowSum += num;
            max = Math.max(max, nowSum);
 
            if (nowSum < 0) {
                nowSum = 0;
            }
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < T; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        
        
        while (!pq.isEmpty()) {
            int a = pq.poll();
            if (pq.isEmpty()) {
                break;
            }
            int b = pq.poll();
            
            int add = a + b;
            
            pq.offer(add);
            
            sum += add;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
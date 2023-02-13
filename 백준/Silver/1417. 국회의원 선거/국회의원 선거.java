import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int ans = 0;
        int first = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        
        for (int i = 0; i < T - 1; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        
        while(!pq.isEmpty() && first <= pq.peek()) {
            ans++;
            first++;
            pq.offer(pq.poll() - 1);
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int totalGem = Integer.parseInt(st.nextToken());
        int totalBag = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Gem> gPq = new PriorityQueue<>((x, y) -> x.w - y.w);
        
        for (int i = 0; i < totalGem; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            gPq.offer(new Gem(w, p));
        }
        
        PriorityQueue<Integer>  bPq = new PriorityQueue<>();
        
        for (int i = 0; i < totalBag; i++) {
            bPq.offer(Integer.parseInt(br.readLine()));
        }
        
        PriorityQueue<Gem> pq = new PriorityQueue<>((x, y) -> y.p - x.p);
        
        long total = 0;
        while(!bPq.isEmpty()) {
            int bagLimit = bPq.poll();
            
            while(!gPq.isEmpty()) {
                int gemLimit = gPq.peek().w;
                
                if (gemLimit <= bagLimit) {
                    pq.offer(gPq.poll());
                } else {
                    break;
                }
            }
            
            if (!pq.isEmpty()) {
                total += pq.poll().p;
            }
        }
        
        bw.write(total + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

class Gem {
    int w;
    int p;
    
    Gem(int w, int p) {
        this.w = w;
        this.p = p;
    }
}
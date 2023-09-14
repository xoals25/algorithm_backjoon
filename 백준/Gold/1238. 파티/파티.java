import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int INF = 1_000_000_000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        
        for (int i = 0; i < M + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());;
            int time = Integer.parseInt(st.nextToken());
            
            graph.get(from).add(new Node(to, time));
        }
       
        int answer = 0;
        
        for (int i = 1; i < N + 1; i++) {
            if (i == X) {
                continue;
            }
            
            answer = Math.max(dickstra(i, X, N) + dickstra(X, i, N), answer);
        }
        
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int dickstra(int from, int to, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[from] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(from, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dist[cur.to] < cur.weight) {
                continue;
            }
            
            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                
                if (dist[adj.to] > cur.weight + adj.weight) {
                    dist[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Node(adj.to, dist[adj.to]));
                }
            }
        }
        
        return dist[to];
    }
}

class Node {
    int to;
    int weight;
    
    Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
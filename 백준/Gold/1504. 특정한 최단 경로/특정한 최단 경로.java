import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static int INF = 100_000_000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        int answer1 = dickstra(1, u, N, graph) 
            + dickstra(u, v, N, graph)
            + dickstra(v, N, N, graph);
        
        int answer2 = dickstra(1, v, N, graph) 
            + dickstra(v, u, N, graph)
            + dickstra(u, N, N, graph);
        
        if (answer1 >= INF && answer2 >= INF) {
            bw.write(-1 + " \n");
        } else {
            bw.write(Math.min(answer1, answer2) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int dickstra(
        int start, 
        int target,
        int N,
        ArrayList<ArrayList<Node>> graph
    ) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (dist[cur.to] < cur.weight) {
                continue;
            }
            
            for(int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                
                if (dist[adj.to] > cur.weight + adj.weight) {
                    dist[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Node(adj.to, dist[adj.to]));
                }
            }
        }
        
        return dist[target];
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

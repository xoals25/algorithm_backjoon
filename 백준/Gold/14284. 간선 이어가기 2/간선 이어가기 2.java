import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int n; //정점 개수
    static int m; // 간선 수
    static int s; // 출발 정점
    static int t; // 끝 정점
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        ArrayList<Node>[] graph = getGraph();
        
        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        
        int[] costs = initCostDp();
        
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        pq.offer(new Node(s, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if (costs[cur.to] < cur.cost) {
                continue;
            }
            
            for (int i = 0; i < graph[cur.to].size(); i++) {
                Node adj = graph[cur.to].get(i);
                int cost = cur.cost + adj.cost;
                
                if (costs[adj.to] > cost) {
                    costs[adj.to] = cost;
                    pq.offer(new Node(adj.to, costs[adj.to]));
                }
            }
        }
        
        bw.write(costs[t] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    private static ArrayList<Node>[] getGraph() throws Exception {
        ArrayList<Node>[] g = new ArrayList[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            g[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            g[a].add(new Node(b, c));
            g[b].add(new Node(a, c));
        }
        
        return g;
    }
    
    private static int[] initCostDp() {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        return cost;
    }
}

class Node {
    int to;
    int cost;
    
    Node(int t, int c) {
        to = t;
        cost = c;
    }
}

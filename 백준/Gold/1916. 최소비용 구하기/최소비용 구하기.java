import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N; // 도시의 개수
    static int M; // 버스의 개수
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine()); 
        M = Integer.parseInt(br.readLine()); 
        
        ArrayList<ArrayList<Node>> graph = getGraph();
        st = new StringTokenizer(br.readLine(), " ");
        
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0));
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            
            if (dist[curNode.to] < curNode.weight) {
                continue;
            }
            
            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);
                
                if (dist[adjNode.to] > curNode.weight + adjNode.weight) {
                    dist[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }
        
        bw.write(dist[end] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static ArrayList<ArrayList<Node>> getGraph() throws Exception {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(start).add(new Node(end, cost));
        }
        
        return graph;
    }
}

class Node {
    int to;
    int weight;
    
    Node(int t, int w) {
        to = t;
        weight = w;
    }
}
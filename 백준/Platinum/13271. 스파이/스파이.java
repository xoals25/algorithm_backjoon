import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
public class Main {
    static int n;
    static int k;
    static BufferedReader br;
    static StringTokenizer st;
    static int INF = 1000000007;
    static int[] dists;
    static ArrayList<Edge> edges;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        dists = new int[1001];
        Arrays.fill(dists, INF);
        dists[0] = 0;
        
        edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            edges.add(new Edge(i, 0, 0));
            edges.add(new Edge(0, i, 100));
        }
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            
            if (type == 1) {
                edges.add(new Edge(a, b, -score));

            } else if (type == 2) {
                edges.add(new Edge(b, a, score));

            } else {
                edges.add(new Edge(a, b, -score));
                edges.add(new Edge(b, a, score));
            }
        }
        
        boolean isMinusCycle = bellmanFord();
        
        if (!isMinusCycle) {
            bw.write(-1 + "\n");
        } else {
            int min = 100;
            for (int i = 1; i <= n; i++) {
                min = Math.min(min, dists[i]);
            }
            
            bw.write((100 - min) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean bellmanFord() {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < edges.size(); j++) {
                Edge cur = edges.get(j);
                
                if (dists[cur.from] < INF 
                    && dists[cur.to] > dists[cur.from] + cur.score) {
                    dists[cur.to] = dists[cur.from] + cur.score;
                    
                    if (i == n) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}

class Edge {
    int from;
    int to;
    int score;
    
    Edge(int from, int to, int score) {
        this.from = from;
        this.to = to;
        this.score = score;
    }
}
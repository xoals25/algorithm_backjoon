import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int ML;
    static int MD;
    static long INF = Long.MAX_VALUE;
    static ArrayList<Edge> edge;
    static long[] distDp;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        ML = Integer.parseInt(st.nextToken());
        MD = Integer.parseInt(st.nextToken());
        
        edge = new ArrayList<>();
        distDp = new long[N + 1];
        Arrays.fill(distDp, INF);
        distDp[1] = 0;
        
        for (int i = 0; i < ML; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            edge.add(new Edge(from, to, dist));
        }
        
        for (int i = ML; i < ML + MD; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            edge.add(new Edge(from, to, -dist));
        }
        
        boolean minusCycle = bellmanFord();
        
        if (!minusCycle) {
            bw.write(-1 + "\n");
        } else if (distDp[N] == INF) {
            bw.write(-2 + "\n");
        } else {
            bw.write(distDp[N] + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean bellmanFord() {
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < edge.size(); j++) {
                Edge cur = edge.get(j);
                
                if (distDp[cur.from] != INF 
                    && distDp[cur.to] > distDp[cur.from] + cur.dist) {
                    distDp[cur.to] = distDp[cur.from] + cur.dist;
                    
                    if (i == N) {
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
    int dist;
    
    Edge(int from, int to, int dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }
}
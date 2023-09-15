import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            
            Edge[] edges = new Edge[M * 2 + W];   
            
            int idx = 0;
            
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges[idx++] = new Edge(s, e, t);
                edges[idx++] = new Edge(e, s, t);
            }
            
            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges[idx++] = new Edge(s, e, -t);
            }
            
            if (ckComebackMinusTime(N, M, W, edges)) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean ckComebackMinusTime(
        int N,
        int M,
        int W,
        Edge[] edges
    ) {
        long[] times = new long[N + 1];
        Arrays.fill(times, INF);
        times[1] = 0;
            
        for (int i = 1; i < N + 1; i++) {
                
            for (int j = 0; j < edges.length; j++) {
                Edge cur = edges[j];
                
                if (times[cur.to] > times[cur.from] + cur.time) {
                    times[cur.to] = times[cur.from] + cur.time;
                        
                    if(i == N) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}

class Edge {
    int from;
    int to;
    long time;
    
    Edge(int from, int to, long time) {
        this.from = from;
        this.to = to;
        this.time =time;
    }
}
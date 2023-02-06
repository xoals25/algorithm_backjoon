import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            bw.write(result() + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static String result() throws Exception {
        return ckMinusCycle() ? "YES" : "NO";
    }
    
    public static boolean ckMinusCycle() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //지점의 수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int W = Integer.parseInt(st.nextToken()); // 웜홀의 개수
        
        Edge[] edge = new Edge[2 * M + W];
        
        int idx = 0;
        while (idx < 2 * M) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            edge[idx++] = new Edge(S, E, T);
            edge[idx++] = new Edge(E, S, T);
        }
        
        for(int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            edge[idx++] = new Edge(S, E, -T);
        }
        
        long[] times = new long[N + 1];

        times[1] = 0;
        
        boolean ck = false;
        
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < edge.length; j++) {
                Edge cur = edge[j];
                
                long time = cur.time + times[cur.from];
                if (times[cur.to] > time) {
                    times[cur.to] = time;
                    
                    if (i == N) {
                        ck = true;
                        break;
                    }
                }
            }
        }
        
        return ck;
    }
}

class Edge {
    int from;
    int to;
    long time;
    
    Edge(int from, int to, long time) {
        this.from = from;
        this.to = to;
        this.time = time;
    }
}
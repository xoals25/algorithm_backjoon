import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N; // 도시 개수
    static int M; // 노선 수
    static BufferedReader br;
    static StringTokenizer st;
    static long INF = 5_000_000;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        long[] times = new long[N + 1];
        Arrays.fill(times, INF);
        times[1] = 0;
        
        boolean isCycle = bellmanFord(times);
        
        if (isCycle) {
            bw.write(-1 + "\n");
        } else {
            for (int i = 2; i < times.length; i++) {
                if(times[i] == INF) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(times[i] + "\n");
                }
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean bellmanFord(long[] times) throws Exception {
        boolean isMinusCycle = false;
        
        Edge[] eg = new Edge[M];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long time = Integer.parseInt(st.nextToken());
            eg[i] = new Edge(from, to, time);
        }
        
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                Edge cur = eg[j];
                
                if (times[cur.from] == INF) {
                    continue;
                }
                
                if (times[cur.to] > times[cur.from] + cur.time) {
                    times[cur.to] = times[cur.from] + cur.time;
                    
                    if (i == N) {
                        isMinusCycle = true;
                        break;
                    }
                }
            }
        }
        
        return isMinusCycle;
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
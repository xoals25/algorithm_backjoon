import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] eyes = new int[N];
        eyes[N - 1] = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            eyes[i] = Integer.parseInt(st.nextToken());
        }

        long[] times = new long[N];
        Arrays.fill(times, Long.MAX_VALUE);

        ArrayList<ArrayList<Node>> graph = getTimeGraph(eyes);

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> Math.toIntExact(x.time - y.time));
        pq.offer(new Node(0, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (times[cur.to] < cur.time) {
                continue;
            }

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);
                long adjTime = cur.time + adj.time;

                if (times[adj.to] > adjTime) {
                    times[adj.to] = adjTime;
                    pq.offer(new Node(adj.to, times[adj.to]));
                }
            }
        }

        if (times[N -1] == Long.MAX_VALUE) {
            bw.write(-1 + "\n");
        } else {
            bw.write(times[N -1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static ArrayList<ArrayList<Node>> getTimeGraph(int[] eyes) throws Exception {
        ArrayList<ArrayList<Node>> g = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (eyes[a] != 1 && eyes[b] != 1) {
                g.get(a).add(new Node(b, t));
                g.get(b).add(new Node(a, t));
            }
        }

        return g;
    }
}

class Node {
    int to;
    long time;

    Node(int to, long time) {
        this.to = to;
        this.time = time;
    }
}
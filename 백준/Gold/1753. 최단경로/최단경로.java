import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int v;
    static int e;
    static int start;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static long[] dist;
    static long INF = 20_000L * 300_000 * 10 + 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        dist = new long[v + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
        }
        dijkstra();

        for (int i = 1; i <= v; i++) {
            if (dist[i] != INF) {
                bw.write(dist[i] + "\n");
            } else {
                bw.write("INF\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.to] < cur.weight) {
                continue;
            }

            for (int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adj = graph.get(cur.to).get(i);

                if (dist[adj.to] > dist[cur.to] + adj.weight) {
                    dist[adj.to] = dist[cur.to] + adj.weight;
                    pq.offer(new Node(adj.to, dist[adj.to]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int to;
    long weight;

    Node(int to, long weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return (int) (this.weight - o.weight);
    }
}
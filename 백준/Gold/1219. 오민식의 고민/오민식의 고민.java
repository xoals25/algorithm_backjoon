import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int v;
    static int e;
    static int start;
    static int end;
    static Edge[] edge;
    static int[] incomes;
    static long INF = Long.MIN_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        edge = new Edge[e];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edge[i] = new Edge(from, to, -cost);
        }

        st = new StringTokenizer(br.readLine(), " ");

        incomes = new int[v];
        for (int i = 0; i < v; i++) {
            incomes[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < edge.length; i++) {
            int to = edge[i].to;
            edge[i].cost += incomes[to];
        }

        long[] costs = new long[v];
        Arrays.fill(costs, INF);
        costs[start] = incomes[start];

        boolean[] cycles = new boolean[v];
        bellmanFord(costs, cycles);

        if (costs[end] == INF) {
            bw.write("gg\n");
        } else if (cycles[end]) {
            bw.write("Gee\n");
        } else {
            bw.write(costs[end]  + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bellmanFord(long[] costs, boolean[] cycles) {
        for (int i = 0; i < 2 * v + 1; i++) {
            for (int j = 0; j < e; j++) {
                Edge cur = edge[j];

                if (cycles[cur.from]) {
                    cycles[cur.to] = true;
                }

                if (costs[cur.from] != INF
                        && costs[cur.to] < costs[cur.from] + cur.cost) {
                    costs[cur.to] = costs[cur.from] + cur.cost;

                    if (i >= v) {
                        cycles[cur.to] = true;
                    }
                }
            }
        }

    }
}

class Edge {
    int from;
    int to;
    int cost;

    Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main  {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int v; // 정점 수
    static int e; // 간선 수

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int[][] arr = new int[e][3];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int weightSum =  kruskal(arr);

        bw.write(weightSum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int prim(int[][] data) {
        int weightSum = 0;

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
            graph.get(data[i][1]).add(new Node(data[i][0], data[i][2]));
        }

        boolean[] visited = new boolean[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(1, 0));

        int cnt = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            cnt += 1;

            if (visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;
            weightSum += cur.weight;

            if (cnt == v) {
                return weightSum;
            }

            for(int i = 0; i < graph.get(cur.to).size(); i++) {
                Node adjNode = graph.get(cur.to).get(i);
                if (!visited[cur.to]) {
                    pq.offer(adjNode);
                }
            }
        }


        return weightSum;
    }

    public static int kruskal(int[][] data) {
        int weightSum = 0;
        int[] parents = new int[v + 1];
        for(int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        Arrays.sort(data, ((x, y) -> (int)x[2] - (int)y[2]));

        for (int i = 0; i < e; i++) {
            int ap = find(data[i][0], parents);
            int bp = find(data[i][1], parents);

            if (ap != bp) {
                union(ap, bp, data[i][0], data[i][1], parents);
                weightSum += data[i][2];
            }
        }

        return weightSum;
    }

    public static void union(int ap, int bp, int a, int b, int[] parents) {
        int max = Math.max(ap, bp);
        int min = Math.min(ap, bp);
        parents[max] = min;
        find(Math.max(a, b), parents);
    }

    public static int find(int a, int[] parents) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a], parents);
    }
}

class Node {
    int to;
    int weight;

    Node(int to, int w) {
        this.to = to;
        weight = w;
    }
}
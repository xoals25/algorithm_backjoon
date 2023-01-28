import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    public static int N;
    public static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        initGraph(graph, st, br);

        int[] distDp = new int[N + 1];
        Arrays.fill(distDp, Integer.MAX_VALUE);
        distDp[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(X, 0));

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (distDp[curNode.to] < curNode.weight) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                int sumWeight = distDp[curNode.to] + adjNode.weight;
                if (distDp[adjNode.to] > sumWeight) {
                    distDp[adjNode.to] = sumWeight;
                    pq.offer(new Node(adjNode.to, distDp[adjNode.to]));
                }
            }
        }

        boolean isK = false;

        for (int i = 1; i < distDp.length; i++) {
            if (distDp[i] == K) {
                isK = true;
                bw.write(i + " \n");
            }
        }

        if (!isK) {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void initGraph(ArrayList<ArrayList<Node>> graph, StringTokenizer st, BufferedReader br) throws Exception {
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            graph.get(num1).add(new Node(num2, 1));
        }
    }
}

class Node {
    int to;
    int weight;

    Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

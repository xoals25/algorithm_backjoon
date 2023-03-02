import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int start; // 시작할 정점 번호
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s][e] = graph[e][s] = 1;
        }

        visited = new boolean[N + 1];

        dfs(start);

        System.out.println();

        visited = new boolean[N + 1];

        bfs();

        br.close();
    }

    public static void dfs(int cur) {
        visited[cur] = true;

        System.out.print(cur + " ");

        for (int i = 0; i < graph[cur].length; i++) {
            if (graph[cur][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (visited[cur]) {
                continue;
            }

            visited[cur] = true;

            System.out.print(cur + " ");

            for (int i = 0 ; i < graph[cur].length; i ++) {
                if (graph[cur][i] == 1 && !visited[i]) {
                    q.offer(i);
                }
            }
        }
    }
}
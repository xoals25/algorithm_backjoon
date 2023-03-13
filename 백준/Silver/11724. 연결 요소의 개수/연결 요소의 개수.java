import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static boolean[] visited;
    static List<List<Integer>> graph;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N + 1];
        graph = new ArrayList<>();
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int count = 0;
        
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == false) {
                count++;
                dfs(i);
            }
        }
        
        System.out.println(count);
        br.close();
    }
    
    public static void dfs(int start) {
        if (visited[start]) {
            return;
        }
        
        visited[start] = true;
        
        for (int i = 0; i < graph.get(start).size(); i++) {
            if (!visited[graph.get(start).get(i)]) {
                dfs(graph.get(start).get(i));
            }
        }
    }
}
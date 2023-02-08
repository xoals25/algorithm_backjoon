import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    static int n; // 교차로의 수 (정점 수)
    static boolean[][] arr;
    static int[] visited;
    static String ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new boolean[n + 1][n + 1];
        visited = new int[n + 1];
        for (int i = 1; i < n; i++) {
            int e = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < e; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][num] = true;
            }
        }
        
        ans = "NO CYCLE";        
        dfs(1);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int v) {
        visited[v] = 1;
        
        for (int i = 1; i < n + 1; i++) {
            if (arr[v][i]) {
                if (visited[i] == 0) {
                    dfs(i);
                } else if (visited[i] == 1) {
                    ans = "CYCLE";
                    return;
                }
            }
        }
        
        visited[v] = 2;
    }
}
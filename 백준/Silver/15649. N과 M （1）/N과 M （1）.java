import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        boolean[] visited = new boolean[N];
        dfs(arr, visited, 0, N);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int[] arr, boolean[] visited, int depth, int N) throws Exception {
        if (depth == arr.length) {
            for (int num: arr) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(arr, visited, depth + 1, N);
                visited[i] = false;
            }
        }

    }
}
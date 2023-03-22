import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int ans;
    static int[][] arr = new int[8][8];
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int virusNum, voidArea;
    static int[][] q = new int[64][2];

    static int bfs() {
        int front = 0;
        int rear = virusNum;
        int res = voidArea - 3;
        boolean[][] visited = new boolean[8][8];
        while (front < rear) {
            int x = q[front][0];
            int y = q[front++][1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (arr[nx][ny] != 0 || visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                q[rear][0] = nx;
                q[rear++][1] = ny;
                res--;
            }
        }
        return res;
    }

    static void dfs(int cnt, int index) {
        if (cnt == 3) {
            int res = bfs();
            if (res > ans)
                ans = res;
            return;
        }
        for (int i = index; i < N * M; i++) {
            int x = i / M;
            int y = i % M;
            if (arr[x][y] != 0)
                continue;
            arr[x][y] = 1;
            dfs(cnt + 1, i + 1);
            arr[x][y] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if (arr[i][j] == 2) {
                    q[virusNum][0] = i;
                    q[virusNum++][1] = j;
                }
                if (arr[i][j] == 0) {
                    voidArea++;
                }
            }
        }

        dfs(0, 0);

        System.out.println(ans);
    }
}

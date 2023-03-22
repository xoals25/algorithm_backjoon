import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N; // 행의 개수 (세로 길이)
    static int M; // 열의 개수 (가로 길이)
    static int[][] board;
    static int zeroCount = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 0) {
                    zeroCount++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int _i = 0; _i < M; _i++) {
                if (board[i][_i] == 0) {
                    board[i][_i] = 1;

                    for (int j = 0; j < N; j++) {
                        for (int _j = 0; _j < M; _j++) {
                            if (board[j][_j] == 0) {
                                board[j][_j] = 1;

                                for (int k = 0; k < N; k++) {
                                    for (int _k = 0; _k < M; _k++) {
                                        if (board[k][_k] == 0) {
                                            board[k][_k] = 1;
                                            int count = birusCountBfs();
                                            max = Math.max(max, zeroCount - count - 3);
                                            board[k][_k] = 0;
                                        }
                                    }
                                }

                                board[j][_j] = 0;
                            }
                        }
                    }

                    board[i][_i] = 0;
                }
            }
        }
        System.out.println(max);
        br.close();
    }

    public static int birusCountBfs() {
        int count = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        boolean[][] visited = new boolean[N][M];

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            if (visited[x][y]) {
                continue;
            }

            if (board[x][y] == 0) {
                count++;
            }

            visited[x][y] = true;

            if (x - 1 >= 0 && !visited[x - 1][y] && board[x - 1][y] == 0) {
                q.offer(new int[]{x - 1, y});
            }

            if (x + 1 < N && !visited[x + 1][y] && board[x + 1][y] == 0) {
                q.offer(new int[]{x + 1, y});
            }

            if (y - 1 >= 0 && !visited[x][y - 1] && board[x][y - 1] == 0) {
                q.offer(new int[]{x, y - 1});
            }

            if (y + 1 < M && !visited[x][y + 1] && board[x][y + 1] == 0) {
                q.offer(new int[]{x, y + 1});
            }
        }

        return count;
    }
}
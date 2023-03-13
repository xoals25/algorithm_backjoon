import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        
        System.out.println(calcCountBFS(N, M, board));
        br.close();
    }
    
    public static int calcCountBFS(int N, int M, int[][] board) {
        // int[0] = x, int[1] = y, int[2] = count;
        Queue<int[]> pq = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        pq.offer(new int[]{0, 0, 1});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            
            if (x == N - 1 && y == M - 1) {
                return count;
            }
            
            if (visited[x][y]) {
                continue;
            }
            
            visited[x][y] = true;
            
            if (x + 1 < N && board[x + 1][y] == 1 && !visited[x + 1][y]) {
                pq.offer(new int[]{x + 1, y, count + 1});
            }
            
            if (y + 1 < M && board[x][y + 1] == 1 && !visited[x][y + 1]) {
                pq.offer(new int[]{x, y + 1, count + 1});
            }
            
            if (x - 1 >= 0 && board[x - 1][y] == 1 && !visited[x - 1][y]) {
                pq.offer(new int[]{x - 1, y, count + 1});
            }
            
            if (y - 1 >= 0 && board[x][y - 1] == 1 && !visited[x][y - 1]) {
                pq.offer(new int[]{x, y - 1, count + 1});
            }
        }
        
        return 0;
    }
}
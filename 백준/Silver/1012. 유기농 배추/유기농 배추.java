import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M = 0;
    static int N = 0;
    static int K = 0;
    static int[][] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            System.out.println(testCase());
        }

        br.close();
    }

    public static int testCase() throws Exception {
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); // 배추 가로 길이
        N = Integer.parseInt(st.nextToken()); // 배추 세로 길이
        K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치의 개수

        arr = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            arr[m][n] = 1;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    search(i, j);
                    result++;
                }
            }
        }

        return result;
    }

    public static void search(int x, int y) {
        if (arr[x][y] == 0) {
            return;
        }

        arr[x][y] = 0;

        if (x - 1 >= 0) {
            search(x - 1, y);
        }

        if (y - 1 >= 0) {
            search(x, y - 1);
        }

        if (x + 1 < M) {
            search(x + 1, y);
        }

        if (y + 1 < N) {
            search(x, y + 1);
        }
    }
}
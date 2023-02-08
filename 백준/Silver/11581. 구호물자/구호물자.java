import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n; // 교차로의 수 (정점 수)
    static boolean[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new boolean[n + 1][n + 1];

        for (int i = 1; i < n; i++) {
            int e = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < e; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][num] = true;
            }
        }

        for (int k = 1; k < n; k++) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        String ans = "NO CYCLE";
        for (int i = 1; i < n; i++) {
            if (arr[1][i] && arr[i][i]) {
                ans = "CYCLE";
                break;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
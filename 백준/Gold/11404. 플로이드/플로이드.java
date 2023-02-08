import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int v; // 정점 수
    static int e; // 간선 수
    static long[][] arr;
    static long INF = 100L * 100_000 * 100_000 + 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        arr = new long[v + 1][v + 1];
        
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }
        
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[to][from] = Math.min(arr[to][from], cost);
        }
        
        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    if (arr[i][k] != INF && arr[k][j] != INF) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }
        
        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                long num = arr[i][j] == INF ? 0 : arr[i][j];
                bw.write(num + " ");
            }
            
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}


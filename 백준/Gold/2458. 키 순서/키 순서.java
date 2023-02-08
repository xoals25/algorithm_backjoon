import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int v;
    static int e;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[v + 1][v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1][n2] = true;
        }

        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        int count = 0;

        for (int j = 1; j < v + 1; j++) {
            boolean ck = true;

            for (int i = 1; i < v + 1; i++) {
                if (i != j && !arr[i][j] && !arr[j][i]) {
                    ck = false;
                }
            }

            if (ck) {
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}



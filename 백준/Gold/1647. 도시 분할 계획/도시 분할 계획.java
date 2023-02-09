import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] data;
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        data = new int[m][3];
        parents = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data, ((x, y) -> x[2] - y[2]));

        long weightSum = kruskal();

        bw.write(weightSum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static long kruskal() {
        long weightSum = 0;
        int w = 0;
        for (int i = 0; i < m; i++) {
            int ap = find(data[i][0]);
            int bp = find(data[i][1]);

            if (ap != bp) {
                union(ap, bp, data[i][0], data[i][1]);
                weightSum += data[i][2];
                w = data[i][2];
            }
        }

        return weightSum - w;
    }

    public static void union(int ap, int bp, int a, int b) {
        int max = Math.max(ap, bp);
        int min = Math.min(ap, bp);
        parents[max] = min;
        find(Math.max(a, b));
    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }
}

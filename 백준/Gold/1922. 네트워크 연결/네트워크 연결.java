import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int v; // 컴퓨터의 수
    static int e; // 선의수
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[e][3];
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, ((x, y) -> (int)x[2] - (int)y[2]));
        
        int weightSum = kruskal(arr);
        bw.write(weightSum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int kruskal(int[][] data) {
        int weightSum = 0;
        
        if (parents == null) {
            parents = new int[v + 1];
            
            for (int i = 1; i <= v; i++) {
                parents[i] = i;
            }
        }
        
        for(int i = 0; i < e; i++) {
            int ap = find(data[i][0]);
            int bp = find(data[i][1]);
            if (ap != bp) {
                union(ap, bp, data[i][0], data[i][1]);
                weightSum += data[i][2];
            }
        }
        
        return weightSum;
    }
    
    public static void union(int ap, int bp, int a, int b) {
        int max = Math.max(ap, bp);
        int min = Math.min(ap, bp);
        
        parents[max] = min;
        find(Math.max(a, b));
    }
    
    public static int find(int a) {
        if (a == parents[a]) {
            return a;
        }
        
        return parents[a] = find(parents[a]);
    }
}
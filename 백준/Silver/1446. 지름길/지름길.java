import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][3];
        
        int[] dist = IntStream.rangeClosed(0, D).toArray();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < dist.length; i++) {
            if (i > 0) {
                dist[i] = Math.min(dist[i], dist[i - 1] + 1);
                
            }
            
            for (int j = 0; j < arr.length; j++) {
                int start = arr[j][0];
                int end = arr[j][1];
                int distance = arr[j][2];
                
                if (i == start && end <= D && dist[i] + distance < dist[end]) {
                    dist[end] = dist[i] + distance;
                }
            }
        }
        bw.write(dist[D] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

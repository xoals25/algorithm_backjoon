import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        

        int[][] arr = new int[T + 1][T + 1];

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= T; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
               
        for (int k = 1; k <= T; k++) {
            for (int i = 1; i <= T; i++) {
                for (int j = 1; j <= T; j++) {
                    if(arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= T; i++) {
            for (int j = 1; j <= T; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
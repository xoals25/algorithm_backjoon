import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
       
        for (int i = 0; i < T; i++) {
            bw.write(calcCount(br) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int calcCount(BufferedReader br) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, ((x, y) -> x[0] - y[0]));
        
        int faceTest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] == 1) {
                answer++;
                break;
            }
            
            if (faceTest >= arr[i][1]) {
                faceTest = arr[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}

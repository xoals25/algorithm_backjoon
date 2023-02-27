import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[T + 1][2];
        arr[0][0] = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i + 1][0] = arr[i][1];
            arr[i + 1][1] = arr[i][0] + arr[i][1];
        }
        
        bw.write(arr[T][0] + " " + arr[T][1]);
        bw.flush();
        bw.close();
        br.close();
    }
}
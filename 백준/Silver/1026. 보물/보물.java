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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[T];
        int[] arr2 = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st2.nextToken());
        }
        
        Arrays.sort(arr);
        Arrays.sort(arr2);
        
        int answer = 0;
        for (int i = 0; i < T; i++) {
            answer += arr[i] * arr2[arr2.length - i - 1];
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int needTotal = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[T];

        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p = 0;
        int q = 0;
        int sum = arr[p];
        int count = 0;

        while (q < T) {
            if (sum < needTotal) {
                q++;
                
                if (q >= T) {
                    break;
                }
                    
                sum += arr[q];
            } else if (sum > needTotal) {
                sum -= arr[p++];
            } else {
                count++;
                q++;
                if (q >= T) {
                    break;
                }
                sum += arr[q];
                sum -= arr[p++];
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
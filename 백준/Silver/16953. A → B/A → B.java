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
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        int count = 1;

        while (A < B) {
            if (B % 10 != 1 && B % 2 != 0) {
                break;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                B /= 2;
            }
            count ++;
        }

        count = A == B ? count : -1;
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

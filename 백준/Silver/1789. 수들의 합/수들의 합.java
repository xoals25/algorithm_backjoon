import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long T = Long.parseLong(br.readLine());
        long sum = 0;
        long idx = 0;
        while (sum <= T) {
            idx++;
            sum += idx;
        }
        
        bw.write((idx - 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
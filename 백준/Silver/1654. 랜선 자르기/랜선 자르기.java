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
        int needLine = Integer.parseInt(st.nextToken());

        long[] lineArr = new long[T];

        long max = 0;
        for (int i = 0; i < T; i++) {
            lineArr[i] = Long.parseLong(br.readLine());

            if (max < lineArr[i]) {
                max = lineArr[i];
            }
        }

        long min = 0;

        while (min <= max) {
            long mid = min + (max - min) / 2;
            long count = 0;
            
            if (mid == 0) {
                mid = 1;
            }

            for (long num: lineArr) {
                count += num / mid;
            }

            if (count < needLine) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int sum = 0;
        boolean isFirst = true;
        while (st.hasMoreElements()) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            int add = 0;

            while (st2.hasMoreElements()) {
                add += Integer.parseInt(st2.nextToken());
            }

            sum = isFirst ? add : sum - add;
            isFirst = false;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
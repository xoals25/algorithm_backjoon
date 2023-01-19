import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
 
        int tPow = (int)Math.pow(2, T);
        look(row,col,tPow);
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void look(int row, int col, int n) {
        if (n == 1) {
            return;
        }
        int half = n / 2;
        if (0 <= row && row < n / 2 && 0 <= col && col < n / 2) {
            look(row, col, half);
        } else if (0 <= row && row < n / 2 && n / 2 <= col && col < n) {
            count += n * n / 4;
            look(row, col - n/2, half);
        } else if (n / 2 <= row && row < n && 0 <= col && col < n / 2) {
            count += (n * n / 4) * 2;
            look(row - n/2, col, half);
        } else {
            count += (n * n / 4) * 3;
            look(row - n/2, col - n/2, half);
        }
    }
}
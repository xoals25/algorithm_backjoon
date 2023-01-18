import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;
public class Main {
    public static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        arr = new int[T][T];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < T; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        bw.write(getSpecialPrize(0, 0, T) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int getSpecialPrize(int x, int y, int n) {
        if (n == 1) {
            return arr[x][y];
        }
        
        int[] tmp = {
                getSpecialPrize(x, y, n / 2),
                getSpecialPrize(x, y + (n / 2), n / 2),
                getSpecialPrize(x + (n / 2), y, n / 2),
                getSpecialPrize(x + (n / 2), y + (n / 2), n / 2)
        };
        Arrays.sort(tmp);
        return tmp[1];
    }
}


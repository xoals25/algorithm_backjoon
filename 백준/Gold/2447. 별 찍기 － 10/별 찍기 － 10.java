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

        int T = Integer.parseInt(br.readLine());
        char[][] arr = new char[T][T];
        int count = 0;

        while(T != 1) {
            count++;
            T /= 3;
        }

        drawStar(arr, 0, 0, count);

        for (char[] cList: arr) {
            StringBuffer sb = new StringBuffer();

            for (char c : cList) {
                if (c == '*') {
                    sb.append('*');
                }
                else {
                    sb.append(' ');
                }
            }

            bw.write(sb.toString() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void drawStar(char[][] arr, int x, int y, int n) {
        if (n == 1) {
            for (int i = x; i < x + 3; i++) {
                for (int j = y; j < y + 3; j++) {
                    if (i % 3 != 1 || j % 3 != 1) {
                        arr[i][j] = '*';
                    }
                }
            }
            return;
        }

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (i % 3 != 1 || j % 3 != 1) {
                    int xx = 3 * i;
                    int yy = 3 * j;

                    drawStar(arr, xx, yy, n - 1);
                }
            }
        }
    }
}
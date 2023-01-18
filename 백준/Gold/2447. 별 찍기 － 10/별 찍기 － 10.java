import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        char[][] arr = new char[T][T];
        int count = 0;

        while(T != 1) {
            count++;
            T /= 3;
        }

        drawStar(arr, 0, 0, count);
        
        StringBuffer sb = new StringBuffer();
        for (char[] cList: arr) {
            for (char c : cList) {
                if (c == '*') {
                    sb.append('*');
                }
                else {
                    sb.append(' ');
                }
            }

            sb.append("\n");
        }
        System.out.print(sb.toString());
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
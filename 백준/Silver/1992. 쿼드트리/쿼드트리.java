import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());


        String[][] arr = new String[T][T];

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = String.valueOf(s.charAt(j));
            }
        }

        bw.write(compress(arr, 0, 0, T) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static String compress(String[][] arr, int x, int y, int n) {
        if (n == 1) {
            return arr[x][y];
        }

        String num1 = compress(arr, x, y, n / 2);
        String num2 = compress(arr, x, y + n / 2, n / 2);
        String num3 = compress(arr, x + n / 2, y, n / 2);
        String num4 = compress(arr, x + n / 2, y + n / 2, n / 2);

        if (num1.equals(num2) && num1.equals(num3) && num1.equals(num4)) {
            return num1.length() == 1 ? num1 : "(" + num1 + num2 + num3 + num4 + ")";
        } else {
            return "(" + num1 + num2 + num3 + num4 + ")";
        }
    }
}
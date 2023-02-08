import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[26][26];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int c1 = s.charAt(0) - 'a';
            int c2 = s.charAt(s.length() - 1) - 'a';
            arr[c1][c2] = true;
        }

        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {

                    if (!arr[i][j] && arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            int c1 = s.charAt(0) - 'a';
            int c2 = s.charAt(s.length() - 1) - 'a';

            char ans = arr[c1][c2] ? 'T' : 'F';
            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
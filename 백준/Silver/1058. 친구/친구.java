import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] friends = new int[T][T];

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            for (int j = 0; j < T; j++) {
                if (i == j) {
                    continue;
                }
                char c = s.charAt(j);
                friends[i][j] = c == 'Y' ? 1 : INF;
            }
        }

        for (int k = 0; k < T; k++) {
            for (int i = 0; i < T; i++) {
                for (int j = 0; j < T; j++) {
                    if (friends[i][k] != INF && friends[k][j] != INF) {
                        friends[i][j] = Math.min(friends[i][j], friends[i][k] + friends[k][j]);
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i < T; i++) {
            int count = 0;
            for (int j = 0; j < T; j++) {
                if (i != j && friends[i][j] <= 2) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int answer = 0;
    public static boolean[][] visited;
    public static int x;
    public static int y;
    public static char[][] chars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        visited = new boolean[x][y];

        chars = new char[x][y];

        for (int i = 0; i < x; i++) {
            String s = br.readLine();

            for (int j = 0; j < y; j++) {
                chars[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!visited[i][j]) {
                    if (chars[i][j] == '-') {
                        dfsWeight('-', i, j);
                    } else {
                        dfsHeight('|', i, j);
                    }
                    answer++;
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfsWeight(char c, int i, int j) {
        if (c != '-') {
            return;
        }

        visited[i][j] = true;

        if (j + 1 >= y) {
            return;
        }

        dfsWeight(chars[i][j + 1], i, j + 1);
    }

    private static void dfsHeight(char c, int i, int j) {
        if (c != '|') {
            return;
        }

        visited[i][j] = true;

        if (i + 1 >= x) {
            return;
        }

        dfsHeight(chars[i + 1][j], i + 1, j);
    }
}

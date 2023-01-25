import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int[] counts = new int[4];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[T][T];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < T; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int finalPaperNum = getPaperNum(arr, 0, 0, T);
        counts[finalPaperNum + 1]++;

        for(int i = 0; i < 3; i++) {
            bw.write(counts[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getPaperNum(int[][] arr, int x, int y, int size) {
        if (size == 1) {
            return arr[x][y];
        }
        int[][] papers = new int[3][3];
        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                papers[i][j] = getPaperNum(arr, x + newSize * i, y + newSize * j , newSize);
            }
        }

        boolean isSame = true;

        for (int[] paper: papers) {
            for(int num: paper) {
                if (num != papers[0][0]) {
                    isSame = false;
                    break;
                }
            }

            if (!isSame) {
                break;
            }
        }

        if (!isSame) {
            for(int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    counts[papers[i][j] + 1]++;
                }
            }
            return 2;
        } else {
            return papers[0][0];
        }
    }
}



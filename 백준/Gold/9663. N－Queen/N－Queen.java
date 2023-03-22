import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] board;
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N];
        nQueen(0);

        System.out.println(count);

        br.close();
    }

    static void nQueen(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[row] = i;

            if (isPromising(row)) {
                nQueen(row + 1);
            }
        }
    }

    static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || row - i == Math.abs(board[row] - board[i])) {
                return false;
            }
        }

        return true;
    }
}
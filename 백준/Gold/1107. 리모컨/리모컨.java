import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int moveNum = Integer.parseInt(br.readLine());
        int brokenCount = Integer.parseInt(br.readLine());

        boolean[] brokenBtns = new boolean[10];

        if (brokenCount > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < brokenCount; i++) {
                brokenBtns[Integer.parseInt(st.nextToken())] = true;
            }
        }

        System.out.println(calcMoveCount(brokenBtns, moveNum));

        br.close();
    }

    public static int calcMoveCount(boolean[] brokenBtns, int moveNum) {
        if (moveNum == 100) {
            return 0;
        }

        int min = Math.abs(100 - moveNum);

        for (int i = 0; i < moveNum + 500_000; i++) {
            String num = String.valueOf(i);

            for (int j = 0; j < num.length(); j++) {
                if (brokenBtns[num.charAt(j) - '0']) {
                    break;
                }

                if (j == num.length() - 1) {
                    min = Math.min(min, num.length() + Math.abs((moveNum - i)));
                }
            }
        }

        return min;
    }
}
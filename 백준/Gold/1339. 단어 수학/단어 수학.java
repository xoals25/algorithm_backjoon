import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static int N;
    static Integer[] lengths;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        lengths = initAlphaLengths();
        Arrays.sort(lengths, (x, y) -> (y - x));

        System.out.println(getAnswer());

        br.close();
    }

    public static Integer[] initAlphaLengths() throws Exception {
        Integer[] lengths = new Integer['Z' - 'A' + 1];
        Arrays.fill(lengths, 0);

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            int length = 1;
            for (int j = s.length() - 1; j >= 0; j--) {
                char c = s.charAt(j);
                lengths[c - 'A'] += length;
                length *= 10;
            }
        }

        return lengths;
    }

    public static int getAnswer() {
        int answer = 0;
        int nowNumber = 9;

        for (Integer length : lengths) {
            if (length == 0) {
                break;
            }
            answer += length * nowNumber--;
        }

        return answer;
    }
}
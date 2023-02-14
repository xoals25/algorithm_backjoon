import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //단어의 개수

        int count = N;

        for (int k = 0; k < N; k++) {
            String s = br.readLine();

            boolean[] ckAlpha = new boolean['z' - 'a' + 1];
            char prev = s.charAt(0);
            ckAlpha[prev - 'a'] = true;

            for (int i = 1; i < s.length(); i++) {
                char cur = s.charAt(i);

                if (prev != cur && ckAlpha[cur - 'a']) {
                    count--;
                    break;
                } else if (prev != cur && !ckAlpha[cur - 'a']) {
                    ckAlpha[cur - 'a'] = true;
                    prev = cur;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
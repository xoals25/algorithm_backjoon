import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().toUpperCase();
        int[] counts = new int['Z' - 'A' + 1];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'A']++;
        }

        int max = 0;
        char answer = '?';

        for (int i = 0; i < counts.length; i++) {
            if (max < counts[i]) {
                max = counts[i];
                answer = (char) ('A' + i);
            } else if (max == counts[i]) {
                answer = '?';
            }
        }

        System.out.println(answer);
        br.close();
    }
}
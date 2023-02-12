import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String[] arr = new String[T];

        for (int i = 0; i < T; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr, ((x, y) -> (y + x).compareTo(x + y)));

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        if (sb.charAt(0) == '0') {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
        
        br.close();
    }
}
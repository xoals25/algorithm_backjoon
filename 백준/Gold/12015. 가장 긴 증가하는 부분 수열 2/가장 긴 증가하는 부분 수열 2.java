import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int BSearch(int[] check, int num, int lis) {
        int left = 0;
        int right = lis;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check[mid] >= num) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        if (left == lis + 1) {
            return -1;
        } else {
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lis = 0;
        for (int i = 0; i < n; i++) {
            int idx = BSearch(check, arr[i], lis);
          //  System.out.println(idx + " i" + i);
            if (idx == -1) {
                check[lis++] = arr[i];
            }
            else {
                check[idx] = arr[i];
            }
        }

        System.out.println(lis);
    }
}
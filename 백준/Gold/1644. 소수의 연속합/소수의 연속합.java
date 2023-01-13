import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        ArrayList<Integer> primeList = getEratosPrime(T);

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (right <= primeList.size()) {
            if (sum == T) {
                count++;
                
                if (right == primeList.size()) {
                    break;
                }
                
                sum += primeList.get(right++);
                sum -= primeList.get(left++);
            } else if (sum > T) {
                sum -= primeList.get(left++);
            } else if (right == primeList.size()) {
                break;
            } else {
                sum += primeList.get(right++);
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static ArrayList<Integer> getEratosPrime(int n) {
        ArrayList<Integer> primeList = new ArrayList<>();
        int[] list = new int[n + 1];

        for (int i = 2; i * i <= n; i++) {
            if (list[i] == 0) {
                for (int j = i * i; j <= n; j+=i) {
                    list[j] = i;
                }
            }
        }

        for (int i = 2; i < list.length; i++) {
            if (list[i] == 0) {
                primeList.add(i);
            }
        }

        return primeList;
    }
}
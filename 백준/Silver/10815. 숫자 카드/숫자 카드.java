import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] cardArr = getDataArray(T, br);
        
        Arrays.sort(cardArr);
        
        T = Integer.parseInt(br.readLine());
        int[] arr = getDataArray(T, br);
        StringBuffer sb = new StringBuffer();
        
        for (int num: arr) {
            if (binarySearch(cardArr, num, 0, cardArr.length - 1) != -1) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }
        
        String answer = sb.toString().trim();
        
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int[] getDataArray(int T, BufferedReader br) throws Exception {
        int[] arr = new int[T];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        return arr;
    }
    
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch(arr, target, left, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, right);
        }
    }
}
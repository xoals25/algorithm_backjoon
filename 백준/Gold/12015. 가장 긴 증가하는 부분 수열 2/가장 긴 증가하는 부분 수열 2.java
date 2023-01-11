import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] arr = new int[T];
     
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] lisArr = new int[T];
        int maxLength = 0;
        
        lisArr[0] = arr[0];
        maxLength++;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > lisArr[maxLength - 1]) {
                lisArr[maxLength++] = arr[i];
            } else if (arr[i] < lisArr[maxLength - 1]) {
                int left = 0;
                int right = maxLength - 1;
                
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    
                    if (lisArr[mid] < arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                
                lisArr[left] = arr[i];
            }
        }
       
        bw.write(maxLength + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        
        int needSum = Integer.parseInt(br.readLine());

        int[] tmp = new int[T];
        mergeSort(arr, tmp, 0, T - 1);
        
        int p = 0;
        int q = T - 1;
        int count = 0;
        
        while (p < q) {
            int sum = arr[p] + arr[q];
            
            if (sum == needSum) {
                count++;
                p++;
            } else if (sum < needSum) {
                p++;
            } else {
                q--;
            }
        }
        
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, tmp, left, mid);
        mergeSort(arr, tmp, mid + 1, right);
        merge(arr, tmp, left, right, mid);
    }
    
    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = p;
        
        while (p <= mid || q <= right) {
            if (p <= mid && q <= right) {
                if (arr[p] <= arr[q]) {
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
            } else if (p <= mid && q > right) {
                tmp[idx++] = arr[p++];
            } else {
                tmp[idx++] = arr[q++];
            }
        }
        
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
}
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] tmp = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        mergeSort(arr, tmp, 0, n - 1);
        
        for (int num: arr) {
            bw.write(num + "\n");
        }
        
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
        int i = left;
        int j = mid + 1;
        int idx = i;
        
        while (i <= mid || j <= right) {
            if (i <= mid && j <= right) {
                if (arr[i] <= arr[j]) {
                    tmp[idx++] = arr[i++];
                } else {
                    tmp[idx++] = arr[j++];
                }
            } else if (i <= mid && j > right) {
                tmp[idx++] = arr[i++];
            } else {
                tmp[idx++] = arr[j++];
            }
        }
        
        for (int p = left; p <= right; p++ ) {
            arr[p] = tmp[p];
        }
    }
}
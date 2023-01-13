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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[T + M];
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = T; i < T + M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] tmp = new int[T + M];
        mergeSort(arr, tmp, 0, T + M - 1);
        
        StringBuffer sb = new StringBuffer();
        sb.append(arr[0]).append(" ");
        for (int i = 1; i < arr.length; i++) {
            
                sb.append(arr[i]);
                
                if (i != arr.length - 1) {
                    sb.append(" ");
                }
            
        }
        
        bw.write(sb.toString() + "\n");

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
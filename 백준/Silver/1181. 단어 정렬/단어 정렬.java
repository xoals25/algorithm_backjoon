import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.HashSet;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            set.add(s);
        }

        String[] arr = set.toArray(new String[0]);
        String[] tmp = new String[set.size()];

        mergeSort(arr, tmp, 0, arr.length - 1);

        for (String s: arr) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void mergeSort(String[] arr, String[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, tmp, left, mid);
        mergeSort(arr, tmp, mid + 1, right);
        merge(arr, tmp, left, right, mid);
    }

    public static void merge(String[] arr, String[] tmp, int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = p;

        while (p <= mid || q <= right) {
            if (p <= mid && q <= right) {
                if (arr[p].length() < arr[q].length()) {
                    tmp[idx++] = arr[p++];
                } else if (arr[p].length() > arr[q].length()) {
                    tmp[idx++] = arr[q++];
                } else {
                    if (arr[p].compareTo(arr[q]) <= -1) {
                        tmp[idx++] = arr[p++];
                    } else {
                        tmp[idx++] = arr[q++];
                    }
                }
            } else if (p <= mid && q > right) {
                tmp[idx++] = arr[p++] ;
            } else {
                tmp[idx++] = arr[q++];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
}
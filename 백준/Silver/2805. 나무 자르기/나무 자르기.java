import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int T = Integer.parseInt(st.nextToken());
        long needTree = Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        
        long[] trees = new long[T];
        long maxHeight = 0;
        
        for (int i = 0; i < T; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            maxHeight = (long)Math.max(maxHeight, trees[i]);
        }
        
        long settingHeight = searchMaxHeight(trees, 0, maxHeight, needTree);
        settingHeight = settingHeight < 0 ? 0 : settingHeight;
        
        bw.write(settingHeight + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static long searchMaxHeight (long[] arr, long min, long max, long needTree) {
        if (min > max) {
            return max;
        }
        
        long mid = min + (max - min) / 2;
        long maxHeight = 0;
        
        for (int i = 0; i < arr.length; i++) {
            maxHeight += arr[i] > mid ? arr[i] - mid : 0;
        }
        
        if (maxHeight < needTree) {
            return searchMaxHeight(arr, min, mid - 1, needTree);
        } else {
            return searchMaxHeight(arr, mid + 1, max, needTree);
        }
    }
}
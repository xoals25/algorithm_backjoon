import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int[] counts = new int[3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[T][T];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            for (int j = 0; j < T; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = countPaper(arr, 0, 0, T);
        counts[count]++;
        
        for (int i = 0; i < 2; i++) {
            bw.write(counts[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int countPaper(int[][] arr, int x, int y, int size) {
        if (size == 1) {
            return arr[x][y];
        }
        
        int halfSize = size / 2;
        
        int[] nums = {
            countPaper(arr, x, y, halfSize),
            countPaper(arr, x, y + halfSize, halfSize),
            countPaper(arr, x + halfSize, y, halfSize),
            countPaper(arr, x + halfSize, y + halfSize, halfSize)
        };

        if (nums[0] == nums[1] && nums[0] == nums[2] && nums[0] == nums[3]) {
            return nums[0];
        } else {
            for (int i = 0; i < 4; i++) {
                counts[nums[i]]++;
            }
            return 2;
        }
    }
}
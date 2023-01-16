import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
       
        for (int i = 0; i < T; i++) {
            bw.write(calcCount(br) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int calcCount(BufferedReader br) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        int[] arr = new int[100_001];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int paperGrade = Integer.parseInt(st.nextToken());
            int faceGrade = Integer.parseInt(st.nextToken());
            arr[paperGrade] = faceGrade;
        }

        int minFaceGrade = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0 && minFaceGrade >= arr[i]) {
                answer++;
                minFaceGrade = arr[i];
            }
        }
        
        return answer;
    }
}

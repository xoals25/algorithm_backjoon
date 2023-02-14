import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        int[] alphaPositions = new int['z' - 'a' + 1];
        Arrays.fill(alphaPositions, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            
            if (alphaPositions[index] == -1) {
                alphaPositions[index] = i;
            }
        }

        for (int alphaPosition : alphaPositions) {
            bw.write(alphaPosition + " ");
        }
        
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
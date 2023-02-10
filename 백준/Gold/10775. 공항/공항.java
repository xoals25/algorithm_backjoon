import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static int[] gates;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        
        gates = new int[G + 1];
        for (int i = 1; i < gates.length; i++) {
            gates[i] = i;
        }
        
        int cnt = 0;
        for (int i = 0; i < T; i++) {
            int gi = Integer.parseInt(br.readLine());
            int ap = find(gi);

            if (ap == 0) {
                break;
            }
            
            int bp = find(ap - 1);
            
            if (ap != bp) {
                union(ap, bp, gi, ap - 1);
            }
            
            cnt++;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void union(int ap, int bp, int a, int b) {
        int max = Math.max(ap, bp);
        int min = Math.min(ap, bp);
        gates[max] = min;
        find(Math.max(a, b));
    }
    
    public static int find(int a) {
        if (gates[a] == a) return a;
        
        return gates[a] = find(gates[a]);
    }
}
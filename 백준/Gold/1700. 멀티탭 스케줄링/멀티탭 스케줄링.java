import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N; // 멀티탭 구멍의 개수
    static int K; // 전기 용품의 총 사용횟수
    static int[] useOrder;
    static Set<Integer> usePlugs = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        useOrder = new int[K];
        
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < K; i++) {
            useOrder[i] = Integer.parseInt(st.nextToken());
        }
        
        int cnt = 0;
        for (int i = 0; i < useOrder.length; i++) {
            if (usePlugs.size() < N) {
                usePlugs.add(useOrder[i]);
            } else if (usePlugs.contains(useOrder[i])) {
                continue;
            } else {
                cnt++;
                
                int removePlug = 0;
                int maxIdx = -1;
                
                for (int usePlug: usePlugs) {
                    int idx = -1;
                    
                    for (int j = i + 1; j < useOrder.length; j++) {
                        if (useOrder[j] == usePlug) {
                            idx = j;
                            break;
                        }
                    }
                    
                    if(idx == -1) {
                        removePlug = usePlug;
                        break;
                    } else if (maxIdx < idx) {
                        maxIdx = idx;
                        removePlug = usePlug;
                    }
                }
                
                usePlugs.remove(removePlug);                
                usePlugs.add(useOrder[i]);
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
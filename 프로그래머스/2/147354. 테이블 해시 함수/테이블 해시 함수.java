import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, ((x, y) -> {
            if (x[col - 1] == y[col - 1]) {
                return y[0] - x[0];
            }
            
            return x[col - 1] - y[col - 1];
        }));
        
        for (int i = row_begin; i <= row_end; i++) {
            answer ^= calcMod(data[i - 1], i);
        }
        
        return answer;
    }
    
    public int calcMod(int[] items, int mod) {
        int answer = 0;
        
        for (int item: items) {
            answer += item % mod;
        }
        
        return answer;
    }
}
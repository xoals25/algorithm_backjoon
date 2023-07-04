import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, ((x, y) -> x[0] - y[0]));
        
        int preStart = targets[0][0];
        int preEnd = targets[0][1];
            
        for (int[] target : targets) {
            if (answer == 0) {
                answer += 1;
                continue;
            }
            
            int curStart = target[0];
            int curEnd = target[1];
            
            if (preStart <= curStart && curStart < preEnd) {
                preStart = Math.max(preStart, curStart);
                preEnd = Math.min(preEnd, curEnd);
            } else {
                preStart = curStart;
                preEnd = curEnd;
                answer += 1;
            }
            
        }
        
        return answer;
    }
}
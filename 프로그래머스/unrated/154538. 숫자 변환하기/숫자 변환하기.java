import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, y});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int count = cur[0];
            int num = cur[1];
            
            if (num == x) {
                return count;
            } 
            
            if (num < x) {
                continue;
            }
            
            if (num % 2 == 0 && num / 2 >= x) {
                q.offer(new int[]{count + 1, num / 2});
            }
            
            if (num % 3 == 0 && num / 3 >= x) {
                q.offer(new int[]{count + 1, num / 3});
            }
            
            if (num - n >= x) {
                q.offer(new int[]{count + 1, num - n});
            }
        }
        
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        Map<Double, Integer> map = new HashMap<>();
        
        for (int w: weights) {
            double num1 = w * 1.0;
            double num2 = w / 2.0;
            double num3 = w / 3.0 * 2.0;
            double num4 = w / 4.0 * 3.0;
            
            answer += map.getOrDefault(num1, 0);
            answer += map.getOrDefault(num2, 0);
            answer += map.getOrDefault(num3, 0);
            answer += map.getOrDefault(num4, 0);
            
            map.put(num1, map.getOrDefault(num1, 0) + 1);
        }
        
        return answer;
    }
}
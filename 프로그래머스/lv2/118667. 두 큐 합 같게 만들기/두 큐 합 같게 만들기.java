import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
                
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(Arrays.stream(queue1).boxed().toArray(Integer[]::new)));
        Queue<Integer> q2 = new LinkedList<>(Arrays.asList(Arrays.stream(queue2).boxed().toArray(Integer[]::new)));
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        
        if (sum1 == sum2) {
            return 0;
        } else if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        
        int count = queue1.length + queue2.length;
        
        while (count >= -(queue1.length + queue2.length)) {
            if (sum1 > sum2 && !q1.isEmpty()) {
                int num1 = q1.poll();

                q2.add(num1);
                
                sum1 -= num1;
                sum2 += num1;
            
            } else if (sum1 < sum2 && !q2.isEmpty()) {
                int num2 = q2.poll();
                
                q1.add(num2);
                
                sum2 -= num2;
                sum1 += num2;
            } else {
                return answer;
            }
            
            answer++;
            count--;
        }
        
        return -1;
    }
    
    
}
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        Queue<String> q1 = initQueue(cards1);
        Queue<String> q2 = initQueue(cards2);
        
        for (String g: goal) {
            if (!q1.isEmpty() && g.equals(q1.peek())) {
                q1.poll();
            } else if (!q2.isEmpty() && g.equals(q2.peek())) {
                q2.poll();
            } else {
                return "No";
            }
        }
        
        return answer;
    }
    
    private Queue<String> initQueue(String[] ss) {
        Queue<String> q = new LinkedList<>();
        for (String s: ss) {
            q.offer(s);
        }
        return q;
    }
}
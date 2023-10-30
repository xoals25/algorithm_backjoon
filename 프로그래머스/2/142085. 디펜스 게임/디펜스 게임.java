import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        
        for (int i = 0; i < enemy.length; i++) {
            if (n < enemy[i] && k <= 0) {
                break;
            }
            
            pq.offer(enemy[i]);
            
            if (n - enemy[i] < 0) {
                n += pq.poll();
                k--;
            }
            
            answer++;
            n -= enemy[i];
        }
        
        return answer;
    }
}
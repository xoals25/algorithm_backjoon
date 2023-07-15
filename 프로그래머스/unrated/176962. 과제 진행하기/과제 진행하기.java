import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        Arrays.sort(plans, ((x, y) -> (x[1]).compareTo(y[1])));
        
        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> y.order - x.order);
        
        for(int i = 0; i < plans.length; i++) {
            String[] plan = plans[i];
            
            String[] times = plan[1].split(":");
            
            String name = plan[0];
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            int playtime = Integer.parseInt(plan[2]);
            
            queue.offer(new Node(name, time, playtime, i));
        }
        
        int idx = 0;
        int nowTime = 0;
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            
            if (queue.isEmpty()) {
                answer[idx++] = cur.name; 
                continue;
            }
            
            Node next = queue.peek();
            
            if (cur.time + cur.playtime > next.time) {
                int num = next.time - cur.time;
                pq.offer(new Node(cur.name, cur.time + num, cur.playtime - num, cur.order));
                nowTime = next.time;
            } else if (cur.time + cur.playtime == next.time) {
                answer[idx++] = cur.name;
                nowTime = next.time;
            } else {
                answer[idx++] = cur.name;
                nowTime = cur.time + cur.playtime;
                
                while(!pq.isEmpty()) {
                    Node pqCur = pq.poll();
                    
                    if (nowTime + pqCur.playtime > next.time) {
                        int num = next.time - nowTime;
                        pq.offer(new Node(pqCur.name, pqCur.time + num, pqCur.playtime - num, pqCur.order));
                        nowTime = next.time;
                        break;
                    } else if (nowTime + pqCur.playtime == next.time) {
                        answer[idx++] = pqCur.name;
                        nowTime = next.time;
                        break;
                    } else {
                        answer[idx++] = pqCur.name;
                        nowTime += pqCur.playtime;
                    }
                }
            }
        }
        
        while(!pq.isEmpty()) {
            answer[idx++] = pq.poll().name;
        }
        
        return answer;
    }
}

class Node {
    String name;
    int time;
    int playtime;
    int order;
    
    public Node (String name, int time, int playtime, int order) {
        this.name = name;
        this.time = time;
        this.playtime = playtime;
        this.order = order;
    }
}

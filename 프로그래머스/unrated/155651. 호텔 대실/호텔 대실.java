import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        Arrays.sort(book_time, (x, y) -> x[0].compareTo(y[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);

        for (String[] book: book_time) {
            String[] starts = book[0].split(":");
            String[] ends = book[1].split(":");
            
            int start = Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]);
            int end = Integer.parseInt(ends[0]) * 60 + Integer.parseInt(ends[1]) + 10;
            
            if (pq.isEmpty()) {
                answer++;
                pq.offer(new int[]{start, end});
                continue;
            } 
            
            int[] prev = pq.poll();
            
            int prevStart = prev[0];
            int prevEnd = prev[1];
            
            if (start >= prevEnd) {
                pq.offer(new int[]{start, end});
            } else {
                answer++;
                pq.offer(new int[]{start, end});
                pq.offer(prev);
            }
        }

        return answer;
    }
}